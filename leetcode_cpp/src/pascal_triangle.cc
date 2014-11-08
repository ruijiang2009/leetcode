/*
 * pascal_triangle.cc
 *
 *  Created on: Nov 6, 2014
 *      Author: ruijiang
 */

#include "pascal_triangle.h"

vector<vector<int> > Solution::generate(int numRows) {
    vector<vector<int> > result;
    if(numRows == 0) {
        return result;
    }
    vector<int> tmp;
    tmp.push_back(1);
    result.push_back(tmp);
    for(int i = 1; i < numRows; i++) {
        vector<int> tmp2;
        tmp2.push_back(1);
        for(int j = 0; j < tmp.size() - 1; j++) {
            tmp2.push_back(tmp[j] + tmp[j+1]);
        }
        tmp2.push_back(1);
        result.push_back(tmp2);
        tmp = tmp2;
    }
    return result;
}


