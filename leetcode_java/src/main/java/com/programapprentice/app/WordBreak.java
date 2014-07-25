package com.programapprentice.app;

/**
 * @author rjiang
 * @date 7/25/14
 */

import java.util.Set;
import java.util.Stack;

/**
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"].
 *
 * Return true because "leetcode" can be segmented as "leet code".
 * */
public class WordBreak {
    public static boolean wordBreak(String s, Set<String> dict) {
        if(s.length() <= 1) {
            return dict.contains(s);
        }
        Stack<String> stack = new Stack<String>();
        Stack<Integer> begStack = new Stack<Integer>();
        String subStr = null;
        int begIndex = 0;
        int endIndex = 1;
        while(endIndex <= s.length()) {
            subStr = s.substring(begIndex, endIndex);
            if(dict.contains(subStr)) {
                stack.push(subStr);
                begStack.push(begIndex);
                begIndex = endIndex;
            } else {
                if(endIndex == s.length()) {
                    if(stack.isEmpty()) {
                        return false;
                    }
                    subStr = stack.pop();
                    begIndex = begStack.pop();
                    endIndex = begIndex + subStr.length();
                }
            }
            endIndex++;
        }
        return true;
    }
}
