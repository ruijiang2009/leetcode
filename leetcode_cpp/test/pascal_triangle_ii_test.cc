/*
 * pascal_triangle_ii_test.cc
 *
 *  Created on: Nov 8, 2014
 *      Author: ruijiang
 */


#include "pascal_triangle_ii.h"
#include "gtest/gtest.h"

TEST(PascalTriangleII, One) {
    Solution obj;
    int input = 3;
    vector<int> actual = obj.getRow(input);
    int array[] = {1, 3, 3, 1};
    vector<int> expected(array, array + sizeof(array) / sizeof(int));
    ASSERT_EQ(expected.size(), actual.size()) << "Vectors expected and actual are of unequal length";

    for (int i = 0; i < expected.size(); ++i) {
      EXPECT_EQ(expected[i], actual[i]) << "Vectors expected and actual differ at index " << i;
    }

}

TEST(PascalTriangleII, Two) {
    Solution obj;
    int input = 2;
    vector<int> actual = obj.getRow(input);
    int array[] = {1, 2, 1};
    vector<int> expected(array, array + sizeof(array) / sizeof(int));
    ASSERT_EQ(expected.size(), actual.size()) << "Vectors expected and actual are of unequal length";

    for (int i = 0; i < expected.size(); ++i) {
      EXPECT_EQ(expected[i], actual[i]) << "Vectors expected and actual differ at index " << i;
    }

}
