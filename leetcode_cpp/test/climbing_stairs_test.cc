/*
 * climbing_stairs_test.cc
 *
 *  Created on: Nov 14, 2014
 *      Author: ruijiang
 */

#include "climbing_stairs.h"
#include "gtest/gtest.h"

TEST(ClimbingStairs, One) {
    Solution obj;
    int expected = 2;
    int actual = obj.climbStairs(2);
    EXPECT_EQ(expected, actual);
}

TEST(ClimbingStairs, Two) {
    Solution obj;
    int expected = 3;
    int actual = obj.climbStairs(3);
    EXPECT_EQ(expected, actual);
}
