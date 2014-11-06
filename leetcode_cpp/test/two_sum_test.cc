#include "two_sum.h"
#include "gtest/gtest.h"


TEST(TwoSum, One) {
    Solution obj;
    int array[] = {2, 7, 11, 15};
    int target = 9;
    vector<int> numbers(array, array + sizeof(array) / sizeof(int) );
    vector<int> actual = obj.twoSum(numbers, target);
    EXPECT_EQ(1, actual[0]);
    EXPECT_EQ(2, actual[1]);
    EXPECT_EQ(2, actual.size());
}

TEST(TwoSum, Two) {
    Solution obj;
    int array[] = {3,2,4};
    int target = 6;
    vector<int> numbers(array, array + sizeof(array) / sizeof(int));
    vector<int> actual = obj.twoSum(numbers, target);
    EXPECT_EQ(2, actual[0]);
    EXPECT_EQ(3, actual[1]);
    EXPECT_EQ(2, actual.size());
}

TEST(TwoSum, Three) {
    Solution obj;
    int array[] = {0,4,3,0};
    int target = 0;
    vector<int> numbers(array, array + sizeof(array) / sizeof(int));
    vector<int> actual = obj.twoSum(numbers, target);
    EXPECT_EQ(1, actual[0]);
    EXPECT_EQ(4, actual[1]);
    EXPECT_EQ(2, actual.size());
}
