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
        for(int i = 0; i < path.size(); i++) {
            sb.append(s.substring(begIndex, path.get(i)+1));
            if(i != path.size()-1) {
                sb.append(" ");
            }
            begIndex = path.get(i)+1;
        }
//        System.out.println(sb.toString());
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
        boolean endReachable = false;
        boolean result[][] = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++) {
            for(int j = i; j < s.length(); j++) {
                if(dict.contains(s.substring(i, j+1))) {
                    result[i][j] = true;
                    if(j == s.length()-1) {
                        endReachable = true;
                    }
                }
            }
        }
        // BFS result
//        List<String> output = new ArrayList<String>();
//        Queue<Integer> queue = new LinkedList<Integer>();
//        Queue<List<Integer>> paths = new LinkedList<List<Integer>>();
//        for(int i = 0; i < s.length(); i++) {
//            if(result[0][i]) {
//                queue.add(i);
//                List<Integer> path = new ArrayList<Integer>();
//                path.add(i);
//                paths.add(path);
//            }
//        }
//        while(!queue.isEmpty()) {
//            int endIndex = queue.remove();
//            List<Integer> partialPath = paths.remove();
//            if(endIndex == s.length()-1) {
//                List<Integer> completePath = partialPath;
//                partialPath.add(endIndex);
//                output.add(getString(s, completePath));
//            } else {
//                for(int i = endIndex + 1; i < s.length(); i++) {
//                    if(result[endIndex+1][i]) {
//                        queue.add(i);
//                        List<Integer> newPartialPath = partialPath;
//                        newPartialPath.add(i);
//                        paths.add(newPartialPath);
//                    }
//                }
//            }
//        }

        // DFS
        List<String> output = new ArrayList<String>();

        if(!endReachable) {
            return output;
        }
        Stack<Integer> stack = new Stack<Integer>();
        Stack<Integer> nodeStack = new Stack<Integer>();
        Stack<List<Integer>> pathStack = new Stack<List<Integer>>();

        List<Integer> path = null;
        stack.push(0);
        nodeStack.push(0);
        path = new ArrayList<Integer>();
        path.add(0);
        pathStack.push(path);

        while(!stack.isEmpty()) {
            int top = stack.peek();
            int node = nodeStack.peek();
            path = pathStack.peek();
            int i = 0;
            for(i = node; i < s.length();i++) {
                if(result[top][i]) {
                    if(i == s.length() - 1) {
                        path.add(i);
                        output.add(getString(s, path));
                        nodeStack.pop();
                        nodeStack.push(s.length());
                    } else {
                        stack.push(i);
                        nodeStack.push(i);
                        path.add(i);
                        pathStack.push(path);
                    }
                    break;
                }
            }

            // didn't find the path
            if(i == s.length()) {
                node = stack.pop();
                nodeStack.pop();
                pathStack.pop();

                if(!nodeStack.isEmpty()) {
                    nodeStack.pop();
                    nodeStack.push(node + 1);
                }
            }

        }
        return output;
    }


}
