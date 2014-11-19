/*
 * longest_common_prefix.cc
 *
 *  Created on: Nov 18, 2014
 *      Author: ruijiang
 */

#include "longest_common_prefix.h"

string Solution::longestCommonPrefix(vector<string> &strs) {
    string s("");
    if(strs.size() == 0) {
        return s;
    }
    if(strs.size() == 1) {
        return strs[0];
    }
    int size = strs.size();
    int preLength = 0;
    char pre;
    while(preLength < strs[0].length()) {
        pre = strs[0][preLength];
        for(int i = 1; i < size; i++) {
            if(pre != strs[i][preLength]) {
                return s;
            }
        }
        s.push_back(pre);
        preLength++;
    }

    return s;
}


