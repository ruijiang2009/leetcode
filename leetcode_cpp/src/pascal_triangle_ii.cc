/*
 * pascal_triangle_ii.cc
 *
 *  Created on: Nov 8, 2014
 *      Author: ruijiang
 */

#include "pascal_triangle_ii.h"

vector<int> Solution::getRow(int rowIndex) {
    vector<int> result;
    result.push_back(1);
    if(0 == rowIndex) {
        return result;
    }
    int pre, cur;
    for(int i = 1; i <= rowIndex; i++) {
        pre = result[0];
        for(int j = 1; j < result.size(); j++) {
            cur = result[j];
            result[j] = result[j] + pre;
            pre = cur;
        }
        result.push_back(1);
    }
    return result;
}


