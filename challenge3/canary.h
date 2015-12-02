/*
 * canary.h
 *
 *  Created on: Dec 2, 2015
 *      Author: klaus
 */

#ifndef CANARY_H_
#define CANARY_H_

void init_canary(char *canary, char *seed);

int check_canary(char *canary, char *seed);

#endif /* CANARY_H_ */
