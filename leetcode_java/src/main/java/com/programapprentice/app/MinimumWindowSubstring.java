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
        int startIndex = 0;
        int endIndex = 0;
        HashMap<Character, Integer> record = new HashMap<Character, Integer>();

        public boolean isComplete(HashMap<Character, Integer> dict, int targetLength) {
            if(targetLength > (endIndex - startIndex + 1)) {
                return false;
            }
            for(Character c : dict.keySet()) {
                if(dict.get(c) < record.get(c)) {
                    return false;
                }
            }
            return true;
        }
    }

    // the method is right, but too slow
    public String minWindowTooSlow(String S, String T) {
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

        HashMap<Character, Integer> sdict = new HashMap<Character, Integer>();
        for(int i = 0; i < S.length(); i++) {
            if(sdict.get(S.charAt(i)) == null) {
                sdict.put(S.charAt(i), 1);
            } else {
                sdict.put(S.charAt(i), sdict.get(S.charAt(i)) + 1);
            }
        }
        if(sdict.keySet().size() > dict.keySet().size()) {
            return "";
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
                    if(subWindow.isComplete(dict, T.length())) {
                        subWindow.endIndex = i;
                        window = S.substring(subWindow.startIndex, subWindow.endIndex+1);
                        if(output == null) {
                            output = window;
                        } else {
                            output = output.length() > window.length() ? window : output;
                        }
                        subWindowList.remove(j);
                    } else {
                        if (output != null) {
                            if (subWindow.endIndex - subWindow.startIndex + 1 > output.length()) {
                                subWindowList.remove(j);
                            }
                        }
                    }
                }
                subWindow = new SubWindow();
                subWindow.startIndex = i;
                subWindow.record.put(S.charAt(i), 1);
                if(subWindow.isComplete(dict, T.length())) {
                    output = String.valueOf(S.charAt(i));
                } else {
                    subWindowList.add(subWindow);
                }
            }
        }
        output = output == null ? "" : output;
        return output;
    }

    public String minWindowV1(String S, String T) {
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

        int start = 0;

        HashMap<Character, Integer> status = new HashMap<Character, Integer>();
        HashMap<Character, Integer> unneededStatus = new HashMap<Character, Integer>();

        int matchedLength = 0;
        String tmpString = null;

        for(int end = 0; end < S.length(); end++) {
            if(dict.get(S.charAt(end)) != null) {
                if(matchedLength == 0) {
                    start = end;
                }
                if(status.get(S.charAt(end)) == null) {
                    status.put(S.charAt(end), 1);
                } else {
                    if(status.get(S.charAt(end)) + 1 <= dict.get(S.charAt(end))) {
                        status.put(S.charAt(end), status.get(S.charAt(end)) + 1);
                    } else {
                        if(unneededStatus.get(S.charAt(end)) == null) {
                            unneededStatus.put(S.charAt(end), 1);
                        } else {
                            unneededStatus.put(S.charAt(end), unneededStatus.get(S.charAt(end)) + 1);
                        }
                        continue;
                    }
                }

                if(status.get(S.charAt(end)) <= dict.get(S.charAt(end))) {
                    matchedLength++;
                    if(T.length() == matchedLength) {
                        tmpString = S.substring(start, end + 1);
                        if (output == null) {
                            output = tmpString;
                        } else {
                            if (tmpString.length() < output.length()) {
                                output = tmpString;
                            }
                        }
                        status.put(S.charAt(start), status.get(S.charAt(start)) - 1);
                        matchedLength--;

                        for(int tmpStart = start + 1; tmpStart < S.length(); tmpStart++) {
                            if (dict.get(S.charAt(tmpStart)) != null) {
                                if (unneededStatus.get(S.charAt(start)) != null && unneededStatus.get(S.charAt(start)) > 0) {
                                    unneededStatus.put(S.charAt(start), unneededStatus.get(S.charAt(start)) - 1);
                                    status.put(S.charAt(start), status.get(S.charAt(start)) + 1);
                                    start = tmpStart;
                                    status.put(S.charAt(start), status.get(S.charAt(start)) - 1);
                                    tmpString = S.substring(start, end + 1);
                                    if (tmpString.length() < output.length()) {
                                        output = tmpString;
                                    }
                                } else {
                                    start = tmpStart;
                                    break;
                                }

                            }
                        }
                    }
                }
            }
        }
        output = output == null ? "" : output;

        return output;
    }

    // compare to minWindowV1 this only use 1 hashmap instead of 2 hashmaps
    public String minWindowV2(String S, String T) {
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

        int start = 0;
        HashMap<Character, Integer> status = new HashMap<Character, Integer>();
        int matchedLength = 0;
        String tmpString = null;
        for(int end = 0; end < S.length(); end++) {

            if(dict.get(S.charAt(end)) != null) {
                if(matchedLength == 0) {
                    start = end;
                }
                if(status.get(S.charAt(end)) == null) {
                    status.put(S.charAt(end), 1);
                    matchedLength++;
                } else {
                    status.put(S.charAt(end), status.get(S.charAt(end)) + 1);
                    if(status.get(S.charAt(end)) <= dict.get(S.charAt(end))) {
                        matchedLength++;
                    }
                }

                if(T.length() == matchedLength) {
                    tmpString = S.substring(start, end + 1);
                    if(output == null) {
                        output = tmpString;
                    } else {
                        if (tmpString.length() < output.length()) {
                            output = tmpString;
                        }
                    }
                    status.put(S.charAt(start), status.get(S.charAt(start)) - 1);
                    matchedLength--;

                    for(int tmpStart = start + 1; tmpStart < S.length(); tmpStart++) {
                        if (dict.get(S.charAt(tmpStart)) != null) {
                            if(status.get(S.charAt(start)) >= dict.get(S.charAt(start))) {
                                start = tmpStart;
                                status.put(S.charAt(start), status.get(S.charAt(start)) - 1);
                                tmpString = S.substring(start, end + 1);
                                if (tmpString.length() < output.length()) {
                                    output = tmpString;
                                }
                            } else {
                                start = tmpStart;
                                break;
                            }

                        }
                    }
                }
            }
        }

        output = output == null ? "" : output;
        return output;
    }

    // Version 3
    // the main performance issue compare with V2 is substring function
    // should use length to compare
    public String minWindow(String S, String T) {
        if(S == null || T == null || S.equals("") || T.equals("") || S.length() < T.length()) {
            return "";
        }
        String output = "";
        HashMap<Character, Integer> dict = new HashMap<Character, Integer>();
        for(int i = 0; i < T.length(); i++) {
            if(dict.get(T.charAt(i)) == null) {
                dict.put(T.charAt(i), 1);
            } else {
                dict.put(T.charAt(i), dict.get(T.charAt(i)) + 1);
            }
        }

        int start = 0;
        HashMap<Character, Integer> status = new HashMap<Character, Integer>();
        int matchedLength = 0;
        int currentLength = S.length() + 1;

        for(int end = 0; end < S.length(); end++) {
            if(dict.get(S.charAt(end)) != null) {
                if(matchedLength == 0) {
                    start = end;
                }
                if(status.get(S.charAt(end)) == null) {
                    status.put(S.charAt(end), 1);
                    matchedLength++;
                } else {
                    status.put(S.charAt(end), status.get(S.charAt(end)) + 1);
                    if(status.get(S.charAt(end)) <= dict.get(S.charAt(end))) {
                        matchedLength++;
                    }
                }

                if(T.length() == matchedLength) {
                    if(end + 1 - start < currentLength ) {
                        output = S.substring(start, end+1);
                        currentLength = end + 1 - start;
                    }
                    status.put(S.charAt(start), status.get(S.charAt(start)) - 1);
                    matchedLength--;

                    for(int tmpStart = start + 1; tmpStart < S.length(); tmpStart++) {
                        if (dict.get(S.charAt(tmpStart)) != null) {
                            if(status.get(S.charAt(start)) >= dict.get(S.charAt(start))) {
                                start = tmpStart;
                                status.put(S.charAt(start), status.get(S.charAt(start)) - 1);
                                if(end + 1 - start < currentLength ) {
                                    output = S.substring(start, end+1);
                                    currentLength = end + 1 - start;
                                }
                            } else {
                                start = tmpStart;
                                break;
                            }

                        }
                    }
                }
            }
        }

        return output;
    }

    public String minWindowSolution(String S, String T) {
        if(S == null || T == null || S.length()==0 || T.length()==0)
            return "";
        HashMap<Character, Integer> dict = new HashMap<Character, Integer>();
        for(int i=0;i<T.length();i++)
        {
            if(dict.containsKey(T.charAt(i)))
            {
                dict.put(T.charAt(i), dict.get(T.charAt(i))+1);
            }
            else
                dict.put(T.charAt(i), 1);
        }
        int count = 0;
        int start = 0;
        String res = "";
        int minLen = S.length()+1;
        for(int i=0;i<S.length();i++)
        {
            if(dict.containsKey(S.charAt(i)))
            {
                dict.put(S.charAt(i),dict.get(S.charAt(i))-1);
                if(dict.get(S.charAt(i))>=0)
                    count++;
                while(count == T.length())
                {
                    if(dict.containsKey(S.charAt(start)))
                    {
                        dict.put(S.charAt(start),dict.get(S.charAt(start))+1);
                        if(dict.get(S.charAt(start))>0)
                        {
                            if(minLen>i-start+1)
                            {
                                res = S.substring(start,i+1);
                                minLen = i-start+1;
                            }
                            count--;
                        }
                    }
                    start++;
                }
            }
        }
        return res;
    }
}
