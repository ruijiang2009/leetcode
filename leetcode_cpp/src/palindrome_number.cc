/*
 * palindrome_number.cc
 *
 *  Created on: Nov 19, 2014
 *      Author: rjiang
 */

#include "palindrome_number.h"
#include <vector>

using namespace::std;

bool Solution::isPalindrome(int x) {
    if(x < 0) {
        return false;
    }
    vector<int> numbers;
    while(x != 0) {
        numbers.push_back(x % 10);
        x = x / 10;
    }
    int halfLength = numbers.size() / 2;
    for(int i = 0; i < halfLength; i++) {
        if(numbers[i] != numbers[numbers.size() - 1 - i]) {
            return false;
        }
    }
    return true;
}


