/*
 * remove_element_test.cc
 *
 *  Created on: Nov 17, 2014
 *      Author: ruijiang
 */

#include "remove_element.h"
#include "gtest/gtest.h"

TEST(RemoveElement, One) {
    Solution obj;
    int A[] = {0, 1, 2, 2, 2, 3, 3, 4};
    int n = 8;
    int elem = 2;
    int expected = 5;
    int actual = obj.removeElement(A, n, elem);
    EXPECT_EQ(expected, actual);
}

TEST(RemoveElement, Two) {
    Solution obj;
    int A[] = {2, 2, 2};
    int n = 3;
    int elem = 2;
    int expected = 0;
    int actual = obj.removeElement(A, n, elem);
    EXPECT_EQ(expected, actual);
}
