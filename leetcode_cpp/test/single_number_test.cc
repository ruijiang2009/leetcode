#include "single_number.h"
#include "gtest/gtest.h"

TEST(SingleNumber, One) {
    Solution obj;
    int array[] = {2, 7, 11, 15, 2, 7, 11};
    int expected = 15;
    int actual = obj.singleNumber(array, 7);
    EXPECT_EQ(expected, actual);
}
