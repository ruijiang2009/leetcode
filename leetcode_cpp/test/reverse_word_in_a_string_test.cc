#include "reverse_word_in_a_string.h"
#include "gtest/gtest.h"


TEST(ReverseWordInAString, One) {
    Solution obj;
    string s = "the sky is blue";
    obj.reverseWords(s);
    EXPECT_EQ("blue is sky the", s);
}
