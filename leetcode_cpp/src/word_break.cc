/*
 * word_break.cc
 *
 *  Created on: Dec 20, 2014
 *      Author: ruijiang
 */

#include "word_break.h"
#include <iostream>


// this version is too slow
//bool Solution::wordBreak(string s, unordered_set<string> &dict) {
//    string sstr;
//    bool result = false;
//    for(int i = 1; i <= s.length(); i++) {
//        sstr = s.substr(0, i);
//        cout << sstr << endl;
//        unordered_set<string>::const_iterator it = dict.find(sstr);
//        if(it != dict.end()) {
//            if(s.length() == i) {
//                return true;
//            }
//            result = wordBreak(s.substr(i, s.length() - i), dict);
//            if(result) {
//                return true;
//            }
//        }
//    }
//    return false;
//}



bool wordBreak(string s, unordered_set<string> &dict) {
    if(s.length() == 0) {
        return true;
    }
    if(1 == s.length()) {
        unordered_set<string>::const_iterator it = dict.find(s);
        if(it == dict.end()) {
            return false;
        } else {
            return true;
        }
    }
    int length = s.length();
    bool result[length];
    for(int i= 0; i < length; i++) {
        result[i] = false;
    }

    string sub;
    unordered_set<string>::const_iterator it;
    for(int i = 0; i < length; i++) {
        sub = s.substr(0, i + 1);
        it = dict.find(sub);
        if(it != dict.end()) {
            result[i] = true;
            continue;
        }
        for(int j = 0; j < i; j++) {
            if(result[j]) {
                sub = s.substr(j + 1, i - j);
                it = dict.find(sub);
                if(it != dict.end()) {
                    result[i] = true;
                    break;
                }
            }
        }
    }
    return result[length - 1];
}
