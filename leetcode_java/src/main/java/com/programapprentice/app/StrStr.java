package com.programapprentice.app;

/**
 * User: ruijiang
 * Date: 9/14/14
 * Time: 9:39 PM
 */

/**
 *
 * Implement strStr().
 *
 * Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of haystack.
 */

public class StrStr {
    public String strStr(String haystack, String needle) {
        if(needle == null || haystack == null) {
            return null;
        }
        if(needle.length() == 0) {
            return haystack;
        }
        if(haystack.length() == 0) {
            return null;
        }
        int[] partialMatchTable = partialMatch(needle);
        int i = 0;
        int j = 0;
        while(i < haystack.length()) {
            while(j >= 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = partialMatchTable[j];
            }
            i++;
            j++;

            if(j == needle.length()) {
                return haystack.substring(i-needle.length());
            }
        }
        return null;
    }

    // create partial match table
    // reference http://tekmarathon.com/2013/05/14/algorithm-to-find-substring-in-a-string-kmp-algorithm/
    public int[] partialMatch(String needle) {
        int[] partialMatchTable = new int[needle.length() + 1];
        int i = 0;
        int j = -1;
        partialMatchTable[0] = -1;
        while( i < needle.length()) {
            while(j >= 0 && needle.charAt(i) != needle.charAt(j)) {
                j = partialMatchTable[j];
            }
            i++;
            j++;
            partialMatchTable[i] = j;
        }
        return partialMatchTable;
    }
}
