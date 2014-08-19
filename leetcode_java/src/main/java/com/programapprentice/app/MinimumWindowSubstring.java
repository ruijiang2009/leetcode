package com.programapprentice.app;

/**
 * @author rjiang
 * @date 8/19/14
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 *
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC".
 *
 * Note:
 * If there is no such window in S that covers all characters in T, return the emtpy string "".
 *
 * If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 * */
public class MinimumWindowSubstring {

    class SubWindow {
        boolean complete = false;
        int startIndex = 0;
        int endIndex = 0;
        HashMap<Character, Integer> record = new HashMap<Character, Integer>();

        public boolean isComplete(HashMap<Character, Integer> dict) {
            for(Character c : dict.keySet()) {
                if(dict.get(c) != record.get(c)) {
                    return false;
                }
            }
            return true;
        }
    }

    public String minWindow(String S, String T) {
        if(S == null || T == null || S.equals("") || T.equals("") || S.length() < T.length()) {
            return "";
        }
        String output = null;
        HashMap<Character, Integer> dict = new HashMap<Character, Integer>();
        for(int i = 0; i < T.length(); i++) {
            if(dict.get(T.charAt(i)) == null) {
                dict.put(T.charAt(i), 1);
            } else {
                dict.put(T.charAt(i), dict.get(T.charAt(i)) + 1);
            }
        }
        List<SubWindow> subWindowList = new ArrayList<SubWindow>();
        SubWindow subWindow = null;
        String window = null;
        for(int i = 0; i < S.length(); i++) {
            if(dict.get(S.charAt(i)) != null) {
                for(int j = subWindowList.size() - 1; j >= 0; j--) {
                    subWindow = subWindowList.get(j);
                    if(subWindow.record.get(S.charAt(i)) == null) {
                        subWindow.record.put(S.charAt(i), 1);
                    } else {
                        subWindow.record.put(S.charAt(i), subWindow.record.get(S.charAt(i)) + 1);
                    }
                    if(subWindow.isComplete(dict)) {
                        subWindow.endIndex = i;
                        window = S.substring(subWindow.startIndex, subWindow.endIndex+1);
                        if(output == null) {
                            output = window;
                        } else {
                            output = output.length() > window.length() ? window : output;
                        }
                        subWindowList.remove(j);
                    }
                }
                subWindow = new SubWindow();
                subWindow.startIndex = i;
                subWindow.record.put(S.charAt(i), 1);
                if(subWindow.isComplete(dict)) {
                    output = String.valueOf(S.charAt(i));
                } else {
                    subWindowList.add(subWindow);
                }
            }
        }
        output = output == null ? "" : output;
        return output;
    }
}
