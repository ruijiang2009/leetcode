#include "plus_one.h"

vector<int> plusOne(vector<int> &digits) {
    digits.push_back(1);
    int carry = 1;
    for(int i = digits.size() - 1; i > 0; i--) {
        digits[i] = (digits[i-1] + carry) % 10;
        carry = (digits[i-1] + carry) / 10;
    }
    if(1 == carry) {
        digits[0] = carry;
        return digits;
    }
    digits.erase(digits.begin());
    return digits;
}
