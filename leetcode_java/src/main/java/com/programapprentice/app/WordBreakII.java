package com.programapprentice.app;

import com.sun.corba.se.spi.orbutil.proxy.LinkedInvocationHandler;

import java.util.*;

/**
 * @author rjiang
 * @date 7/28/14
 */

/**
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

 * Return all such possible sentences.

 For example, given
 s = "catsanddog",
 dict = ["cat", "cats", "and", "sand", "dog"].

 A solution is ["cats and dog", "cat sand dog"].
 */
public class WordBreakII {

    public static String getString(String s, Stack<Integer> stack) {
        StringBuilder sb = new StringBuilder("");
        int begIndex = 0;
        int endIndex = 0;
        while(!stack.isEmpty()) {
            endIndex = stack.pop() + 1;
            sb.append(s.substring(begIndex, endIndex));
            sb.append(" ");
            begIndex = endIndex;
        }
        return sb.toString().trim();
    }

    public static List<String> wordBreak(String s, Set<String> dict) {
        if(s.length() <= 1) {
            List<String> output = new ArrayList<String>();
            if(dict.contains(s)) {
                output.add(s);
            }
            return output;
        }

        ArrayList<ArrayList<Integer>> endWith = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < s.length(); i++) {
            endWith.add(new ArrayList<Integer>());
        }

        ArrayList<Integer> node = null;
        for(int end = 0; end < s.length(); end++) {
            node = endWith.get(end);
            for (int beg = end-1; beg >= -1; beg--) {
                if(dict.contains(s.substring(beg+1, end+1))) {
                    node.add(beg+1);
                }
            }
        }

        List<String> output = new ArrayList<String>();

        if(endWith.get(s.length() - 1).isEmpty()) {
            return output;
        }

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(s.length() - 1);
        Stack<Integer> cursorStack = new Stack<Integer>();
        cursorStack.add(0);  // this is node's cursor
        while(!stack.isEmpty()) {
            int top = stack.peek();
            int cursor = cursorStack.peek();
            node = endWith.get(top);
            if(cursor < node.size()) {
                if(node.get(cursor) == 0) {
                    output.add(getString(s, (Stack<Integer>)stack.clone()));
                    cursorStack.pop();
                    stack.pop();

                    if(!cursorStack.empty()) {
                        cursor = cursorStack.pop();
                        cursorStack.push(cursor + 1);
                    }
                } else {
                    if(!endWith.get(node.get(cursor) - 1).isEmpty()) {
                        stack.push(node.get(cursor) - 1);
                        cursorStack.push(0);
                    } else {
                        cursor = cursorStack.pop();
                        cursorStack.push(cursor + 1);
                    }
                }
            } else {
                stack.pop();
                cursorStack.pop();
                if(!cursorStack.empty()) {
                    cursor = cursorStack.pop();
                    cursorStack.push(cursor + 1);
                }
            }
        }

        return output;
    }

}
