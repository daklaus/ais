/*
 * canary.c
 *
 *  Created on: Dec 2, 2015
 *      Author: klaus
 */

void init_canary(char *canary, char *seed) {
    *canary = seed[0];
}

int check_canary(char *canary, char *seed) {
    return *canary == *seed;
}
