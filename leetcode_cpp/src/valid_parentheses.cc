/*
 * valid_parentheses.cc
 *
 *  Created on: Nov 17, 2014
 *      Author: ruijiang
 */


#include "valid_parentheses.h"
#include <stack>

bool Solution::isValid(string s) {
    if(s.empty()) {
        return true;
    }
    stack<char> mystack;

    for(int i = 0; i < s.length(); i++) {
        switch(s[i]) {
        case '(':
            mystack.push(s[i]);
            break;
        case ')':
            if(!mystack.empty() && '(' == mystack.top()) {
                mystack.pop();
            } else {
                return false;
            }
            break;
        case '[':
            mystack.push(s[i]);
            break;
        case ']':
            if(!mystack.empty() && '[' == mystack.top()) {
                mystack.pop();
            } else {
                return false;
            }
            break;
        case '{':
            mystack.push(s[i]);
            break;
        case '}':
            if(!mystack.empty() && '{' == mystack.top()) {
                mystack.pop();
            } else {
                return false;
            }
            break;
        }
    }
    if(mystack.empty()) {
        return true;
    }
    return false;
}

