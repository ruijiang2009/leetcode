/*
 * length_of_last_word.cc
 *
 *  Created on: Nov 16, 2014
 *      Author: ruijiang
 */

#include "length_of_last_word.h"

int Solution::lengthOfLastWord(const char *s) {
    int cursor = 0;
    int length = 0;
    bool newBegin = false;
    while(s[cursor] != '\0') {
        if(' ' == s[cursor]) {
            newBegin = true;
        } else {
            if(newBegin) {
                length = 1;
                newBegin = false;
            } else {
                length++;
            }
        }
        cursor++;
    }
    return length;
}

