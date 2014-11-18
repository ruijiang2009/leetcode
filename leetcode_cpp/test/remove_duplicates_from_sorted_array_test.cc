/*
 * remove_duplicates_from_sorted_array_test.cc
 *
 *  Created on: Nov 17, 2014
 *      Author: ruijiang
 */

#include "remove_duplicates_from_sorted_array.h"
#include "gtest/gtest.h"

TEST(RemoveDuplicatesFromSortedArray, One) {
    Solution obj;
    int A[] = {0, 1, 2, 2, 2, 3, 3, 4};
    int n = 8;
    int expected = 5;
    int actual = obj.removeDuplicates(A, n);
    EXPECT_EQ(expected, actual);
}

TEST(RemoveDuplicatesFromSortedArray, Two) {
    Solution obj;
    int A[] = {2, 2, 2};
    int n = 3;
    int expected = 1;
    int actual = obj.removeDuplicates(A, n);
    EXPECT_EQ(expected, actual);
}


