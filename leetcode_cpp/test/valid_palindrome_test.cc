#include "valid_palindrome.h"
#include "gtest/gtest.h"

TEST(ValidPalindrome, One) {
    Solution obj;
    string input("A man, a plan, a canal: Panama");
    bool expected = true;
    bool actual = obj.isPalindrome(input);
    EXPECT_EQ(expected, actual);
}

TEST(ValidPalindrome, Two) {
    Solution obj;
    string input("race a car");
    bool expected = false;
    bool actual = obj.isPalindrome(input);
    EXPECT_EQ(expected, actual);
}

TEST(ValidPalindrome, Three) {
    Solution obj;
    string input(".a");
    bool expected = true;
    bool actual = obj.isPalindrome(input);
    EXPECT_EQ(expected, actual);
}
