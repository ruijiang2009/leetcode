#include <iostream>
#include <stack>

#include "reverse_word_in_a_string.h"

using namespace::std;

/**
Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".

click to show clarification.

Clarification:
What constitutes a word?
A sequence of non-space characters constitutes a word.
Could the input string contain leading or trailing spaces?
Yes. However, your reversed string should not contain leading or trailing spaces.
How about multiple spaces between two words?
Reduce them to a single space in the reversed string.
*/


void Solution::reverseWords(string &s) {
    string output = "";
    int length = s.length();
    int start = -1;
    int end = -1;
    bool wordStarted = false;
    for(int i = length-1; i >= 0; i--) {
        if(s[i] == ' ') {
            if(wordStarted) {
                if(0 == output.length()) {
                    output = s.substr(start, end-start+1);
                } else {
                    output += ' ';
                    output += s.substr(start, end-start+1);
                }
                wordStarted = false;
            }
            continue;
        } else {
            if(-1 == end) {
                end = i;
                start = i;
                wordStarted = true;
            } else {
                if(wordStarted) {
                    start = i;
                } else {
                    end = i;
                    wordStarted = true;
                    start = end;
                }
            }
        }
    }
    // dealing with the first string
    if(wordStarted) {
        if(output.length() > 0) {
            output += ' ';
        }
        output += s.substr(start, end-start+1);
    }
    s = output;
}
