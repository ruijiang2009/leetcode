/*
 * pascal_triangle_test.cc
 *
 *  Created on: Nov 6, 2014
 *      Author: ruijiang
 */

#include "pascal_triangle.h"
#include "gtest/gtest.h"


void print(vector<vector<int> > result) {
    for(int i = 0; i < result.size(); i++) {
        vector<int> list = result[i];
        for(int j = 0; j < list.size(); j++) {
            cout << list[j] << '\t';
        }
        cout << endl;
    }
}

TEST(PascalTriangle, One) {
    Solution obj;
    int input = 3;
    vector<vector<int> > actual = obj.generate(input);
    print(actual);
}



