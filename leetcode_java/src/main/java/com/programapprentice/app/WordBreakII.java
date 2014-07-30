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

    public static String getString(String s, List<Integer> path) {
        StringBuilder sb = new StringBuilder("");
        int begIndex = 0;
        int endIndex = 0;
        for(int i = path.size(); i > 1; i--) {
            begIndex = path.get(i-1);
            endIndex = path.get(i-2);
            sb.append(s.substring(begIndex, endIndex));
            sb.append(" ");
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
        stack.push(endWith.get(s.length() - 1).get(0));
        Stack<ArrayList<Integer>> pathStack = new Stack<ArrayList<Integer>>();
        ArrayList<Integer> path = new ArrayList<Integer>();
        path.add(s.length()-1);
        Stack<Integer> cursorStack = new Stack<Integer>();
        cursorStack.add(0);  // this is node's cursor
        while(!stack.isEmpty()) {
            int top = stack.peek();
            int cursor = cursorStack.peek();
            path = pathStack.peek();
            node = endWith.get(top);
            if(cursor < node.size()) {
                stack.push(node.get(cursor));
                path.add(node.get(cursor));
                pathStack.add(path);
                cursorStack.push(0);

                // generate new path
                if(node.get(cursor) == 0) {
                    output.add(getString(s, path));
                }
            } else {
                stack.pop();
                cursorStack.pop();
                pathStack.pop();
                top = stack.peek();
                node = endWith.get(top);
                cursor = cursorStack.pop();
                if(cursor < node.size()) {
                    cursorStack.push(node.get(cursor+1));
                } else {
                    cursorStack.push(s.length());
                }
            }
        }

        return output;
    }

}
/**
 * procedure DFS-iterative(G,v):
 *     let S be a stack
 *     S.push(v)
 *     while S is not empty
 *           v ← S.pop()
 *           if v is not labeled as discovered:
 *               label v as discovered
 *               for all edges from v to w in G.adjacentEdges(v) do
 *                   S.push(w)
 * */