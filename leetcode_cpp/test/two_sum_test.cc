#include "two_sum.h"
#include "gtest/gtest.h"


TEST(TwoSum, One) {
    Solution obj;
    string s = "the sky is blue";
    obj.reverseWords(s);
    EXPECT_EQ("blue is sky the", s);
}
