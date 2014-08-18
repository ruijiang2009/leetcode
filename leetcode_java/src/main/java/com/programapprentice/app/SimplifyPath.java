package com.programapprentice.app;

/**
 * @author rjiang
 * @date 8/18/14
 */

import java.util.Stack;

/**
 * Given an absolute path for a file (Unix-style), simplify it.
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * */
public class SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> pathStack = new Stack<String>();
        int startIndex = 0;
        startIndex = path.indexOf('/', 0);
        int endIndex = 0;
        String dir = null;
        while(startIndex != -1) {
            endIndex = path.indexOf('/', startIndex+1);
            if(endIndex != -1) {
                dir = path.substring(startIndex + 1, endIndex);
            } else {
                dir = path.substring(startIndex + 1, path.length());
            }
            if(dir.equals("..")) {
                if(!pathStack.isEmpty()) {
                    pathStack.pop();
                }
            } else if (!(dir.equals(".") || dir.equals(""))) {
                pathStack.push(dir);
            }
            startIndex = endIndex;
        }
        String output = "";
        while(!pathStack.isEmpty()) {
            String top = pathStack.pop();
            output = "/" + top + output;
        }
        if(output.equals("")) {
            output = "/";
        }
        return output;
    }
}
