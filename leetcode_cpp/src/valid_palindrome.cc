#include "valid_palindrome.h"
#include <iostream>

using namespace::std;

bool Solution::isPalindrome(string s) {
    if(s.length() < 2) {
        return true;
    }
    int n = s.length();
    int low = 0;
    int high = n - 1;
    while(low <= high) {
        if(!isalnum(s[low])) {
            low++;
            continue;
        }
        if(!isalnum(s[high])) {
            high--;
            continue;
        }
        char a = islower(s[low]) ? s[low] : tolower(s[low]);
        char b = islower(s[high]) ? s[high] : tolower(s[high]);
        if(a != b) {
            return false;
        }
        low++;
        high--;
    }
    return true;
}
