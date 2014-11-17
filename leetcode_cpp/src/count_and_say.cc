/*
 * count_and_say.cc
 *
 *  Created on: Nov 16, 2014
 *      Author: ruijiang
 */

#include "count_and_say.h"
#include <iostream>

string Solution::countAndSay(int n) {
    if(n == 0) {
        return "";
    }
    string s("1");
    int length = 0;
    int j = 0;
    int counter = 0;
    char cur;
    string tmp("");
    for(int i = 1; i < n; i++) {
        length = s.length();
        j = 1;
        cur = s[0];
        counter = 1;
        while(j < length) {
            if(cur == s[j]) {
                counter++;
            } else {
                tmp.append(to_string(counter));
                tmp.append(1, cur);
                cur = s[j];
                counter = 1;
            }
            j++;
        }
        tmp.append(to_string(counter));
        tmp.append(1, cur);
        s = tmp;
        tmp.clear();
    }
    return s;
}
