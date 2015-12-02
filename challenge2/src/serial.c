/*
 ============================================================================
 Name        : challenge2.c
 Author      : Klaus Krapfenbauer
 Version     :
 Copyright   :
 Description :
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>
#include <string.h>

uint32_t umult64(uint32_t a, uint32_t b, uint32_t* c) {
    uint64_t x = (uint64_t) a * b;
    *c = x >> 32;
    return x & 0xffffffff;
}

int main(int argc, char ** argv) {

    if(argc != 2) {
        return 8;
    }

    const char pascii[] = "!$%&/()=?abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    char username[10];

    strncpy((char *) &username, argv[1], 10);

    char serial[10];

    uint32_t x, y, z;
    uint32_t u, v, w;
    char curr_char, next_char;
    const uint32_t CONS = 0xe6c2b449;

    serial[0] = username[0];

    int i;
    for(i = 0; i < 9; i++) {
        curr_char = serial[i];

        // For the last character
        if(i >= 8) {
            x = ~curr_char;
        } else {
            next_char = username[i+1];

            x = curr_char + next_char;
        }
        y = x;

        u = umult64(CONS, x, &x);

        x >>= 6;
        v = x;
        x <<= 3;
        x += v;
        x <<= 3;
        x -= v;

        y -= x;
        v = y;

        serial[i+1] = pascii[y];

//        printf("0x%x 0x%x\n", v, u);
//        printf("%c", serial[i+1]);
    }

    printf("%.10s", serial);

	return EXIT_SUCCESS;
}
