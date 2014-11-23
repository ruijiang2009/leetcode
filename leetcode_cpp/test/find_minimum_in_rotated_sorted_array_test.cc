/*
 * find_minimum_in_rotated_sorted_array_test.cc
 *
 *  Created on: Nov 22, 2014
 *      Author: ruijiang
 */

#include "find_minimum_in_rotated_sorted_array.h"
#include "gtest/gtest.h"

TEST(FindMinimumInRotatedSortedArray, One) {
    Solution obj;
    int array[] = {4, 5, 6, 7, 0, 1, 2};
    int expected = 0;
    vector<int> input(array, array + sizeof array / sizeof array[0]);
    int actual = obj.findMin(input);
    EXPECT_EQ(expected, actual);
}

TEST(FindMinimumInRotatedSortedArray, Two) {
    Solution obj;
    int array[] = {0, 1, 2, 4, 5, 6, 7};
    int expected = 0;
    vector<int> input(array, array + sizeof array / sizeof array[0]);
    int actual = obj.findMin(input);
    EXPECT_EQ(expected, actual);
}

TEST(FindMinimumInRotatedSortedArray, Three) {
    Solution obj;
    int array[] = {1};
    int expected = 1;
    vector<int> input(array, array + sizeof array / sizeof array[0]);
    int actual = obj.findMin(input);
    EXPECT_EQ(expected, actual);
}

TEST(FindMinimumInRotatedSortedArray, Four) {
    Solution obj;
    int array[] = {1, 2};
    int expected = 1;
    vector<int> input(array, array + sizeof array / sizeof array[0]);
    int actual = obj.findMin(input);
    EXPECT_EQ(expected, actual);
}

TEST(FindMinimumInRotatedSortedArray, Five) {
    Solution obj;
    int array[] = {2, 1};
    int expected = 1;
    vector<int> input(array, array + sizeof array / sizeof array[0]);
    int actual = obj.findMin(input);
    EXPECT_EQ(expected, actual);
}

