package com.programapprentice.app;

/**
 * @author rjiang
 * @date 8/19/14
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * For example,
 * Given:
 * s1 = "aabcc",
 * s2 = "dbbca",
 *
 * When s3 = "aadbbcbcac", return true.
 * When s3 = "aadbbbaccc", return false.*/
public class InterleavingString {
    class Status {
        int index1 = 0;
        int index2 = 0;
        int index3 = 0;

        public Status(int index1, int index2, int index3) {
            this.index1 = index1;
            this.index2 = index2;
            this.index3 = index3;
        }
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1 == null || s1.equals("")) {
            if(s2 == null) {
                return s2 == s3;
            } else {
                return s2.equals(s3);
            }
        }
        if(s2 == null || s2.equals("")) {
            if(s1 == null) {
                return s1 == s3;
            } else {
                return s1.equals(s3);
            }
        }
        if(s1.length() + s2.length() != s3.length()) {
            return false;
        }
        int index1 = 0;
        int index2 = 0;
        int index3 = 0;
        Queue<Status> queue = new LinkedList<Status>();
        if(index1 < s1.length() && s1.charAt(index1) == s3.charAt(index3)) {
            queue.add(new Status(index1 + 1, index2, index3 + 1));
        }
        if(index2 < s2.length() && s2.charAt(index2) == s3.charAt(index3)) {
            queue.add(new Status(index1, index2 + 1, index3 + 1));
        }

        Status status = null;
        while(!queue.isEmpty()) {
            status = queue.remove();
            index1 = status.index1;
            index2 = status.index2;
            index3 = status.index3;
            if(index3 == s3.length()) {
                return true;
            }
            if(index1 < s1.length() && s1.charAt(index1) == s3.charAt(index3)) {
                queue.add(new Status(index1 + 1, index2, index3 + 1));
            }
            if(index2 < s2.length() && s2.charAt(index2) == s3.charAt(index3)) {
                queue.add(new Status(index1, index2 + 1, index3 + 1));
            }
        }

        return false;
    }
}
