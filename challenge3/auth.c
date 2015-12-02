/*
 * auth.c
 *
 *  Created on: Dec 2, 2015
 *      Author: klaus
 */

#include <unistd.h>
#include <string.h>

#define USER "inetsec028"
#define PASSWORD "aezuthah"

int auth_user(char *user, char *pass) {
    if (strncmp(user, USER, sizeof(USER) - 1))
        return 0;
    if (strncmp(pass, PASSWORD, sizeof(PASSWORD) - 1))
        return 0;

    return getuid();
}
