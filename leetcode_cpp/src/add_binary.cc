/*
 * add_binary.cc
 *
 *  Created on: Nov 14, 2014
 *      Author: ruijiang
 */

#include "add_binary.h"
#include <iostream>

string Solution::addBinary(string a, string b) {
    int alength = a.length();
    int blength = b.length();
    int clength = alength > blength ? alength + 1 : blength + 1;
    string c(clength, '0');
    int length = alength > blength ? blength : alength;
    int aint = 0, bint = 0, cint = 0, carry = 0;
    int i = 0;
    for(; i < length; i++) {
        if(a[alength - 1 - i] == '0') {
            aint = 0;
        } else {
            aint = 1;
        }
        if(b[blength - 1 - i] == '0') {
            bint = 0;
        } else {
            bint = 1;
        }
//        aint = a[alength - 1 - i] - '0';
//        bint = b[blength - i - i] - '0';
        cint = (aint + bint + carry) % 2;
        carry = (aint + bint + carry) / 2;
        if(0 == cint) {
            c[clength - 1 - i] = '0';
        } else {
            c[clength - 1 - i] = '1';
        }
    }
    if (blength > length) {
        a = b;
        alength = blength;
    }

    for(; i < alength; i++) {
        if(a[alength - 1 - i] == '0') {
            aint = 0;
        } else {
            aint = 1;
        }
//        aint = a[alength - 1 - i] - '0';
        cint = (aint + carry) % 2;
        carry = (aint + carry) / 2;
        if(0 == cint) {
            c[clength - 1 - i] = '0';
        } else {
            c[clength - 1 - i] = '1';
        }
    }
    if(0 == carry) {
        c = c.substr(1);
    } else {
        c[0] = '1';
    }

    return c;
}



