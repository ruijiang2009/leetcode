package com.programapprentice.app;

import java.util.*;

/**
 * @author rjiang
 * @date 8/11/14
 */
public class PalindromePartitioning {
    public List<List<String>> partitionTooSlow(String s) {
        List<List<String>> output = new ArrayList<List<String>>();
        if(s == null || s.length() == 0) {
            return output;
        }
        if(s.length() == 1) {
            List<String> l  = new ArrayList<String>();
            l.add(s);
            output.add(l);
            return output;
        }
        List<List<String>> subList = partitionTooSlow(s.substring(1));
        Boolean hasPalindrome = false;
        for(List<String> l : subList) {
            List<String> newl = new ArrayList<String>(l);
            newl.add(0, String.valueOf(s.charAt(0)));
            output.add(newl);
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(s.charAt(0)));
            newl = new ArrayList<String>();
            hasPalindrome = false;
            for(String str : l) {
                if(hasPalindrome == false) {
                    sb.append(str);
                    if (isPalindrome(sb.toString())) {
                        hasPalindrome = true;
                        newl.add(sb.toString());
                    }
                } else {
                    newl.add(str);
                }
            }
            if(hasPalindrome) {
                output.add(newl);
            }
        }

        return output;
    }

    public boolean isPalindrome(String s) {
        if(s == null || s.length() <= 1) {
            return true;
        }
        int mid = s.length() / 2;
        for(int i = 0; i < mid; i++) {
            if(s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public String findPalindrome(String input, int startIndex, int minLength) {
        for(int i = startIndex + minLength; i < input.length(); i++) {
            if(isPalindrome(input.substring(startIndex, i+1))) {
                return input.substring(startIndex, i+1);
            }
        }
        return null;
    }

//    public List<List<String>> partition(String s) {
//        List<String> strStack = new ArrayList<String>();
//        List<Integer> indexStack = new ArrayList<Integer>();
//        List<Integer> palindromeLengthStack = new ArrayList<Integer>();
//
//        List<List<String>> output = new ArrayList<List<String>>();
//
//        strStack.add(String.valueOf(s.charAt(0)));
//        indexStack.add(0);
//        palindromeLengthStack.add(1);
//        int curEndIndex = 0;
//        int startIndex = 0;
//        int minLength = 0;
//        int minLengthFromBegin = 1;
//        String tmp = null;
//        List<String> one = null;
//        while(!(strStack.isEmpty() && findPalindrome(s, 0, minLengthFromBegin) == null)) {
//            if(strStack.isEmpty()) {
//
//            } else {
//                startIndex = indexStack.get(indexStack.size()) + 1;
//                minLength = palindromeLengthStack.get(palindromeLengthStack.size()-1);
//                if(startIndex == s.length()) {
//                    one = new ArrayList<String>();
//                    for(String str : strStack) {
//                        one.add(str);
//                    }
//                    output.add(one);
//                    strStack.remove(strStack.size() - 1);
//                    indexStack.remove(indexStack.size() - 1);
//                    palindromeLengthStack.remove(palindromeLengthStack.size() - 1);
//                    palindromeLengthStack.set(palindromeLengthStack.size() - 1,
//                            minLength + 1);
//                } else {
//
//                    tmp = findPalindrome(s, startIndex, minLength);
//                    if (tmp != null) {
//                        strStack.add(tmp);
//                        indexStack.add(startIndex + tmp.length() - 1);
//                        palindromeLengthStack.add(tmp.length());
//                    } else {
//                        strStack.remove(strStack.size() - 1);
//                        indexStack.remove(indexStack.size() - 1);
//                        palindromeLengthStack.remove(palindromeLengthStack.size() - 1);
//                        palindromeLengthStack.set(palindromeLengthStack.size() - 1,
//                                palindromeLengthStack.get(palindromeLengthStack.size() - 1) + 1);
//
//                    }
//                }
//            }
//        }
//        return output;
//    }



    public List<String> findPalindromes(String input, int startIndex) {
        List<String> output = new ArrayList<String>();
        for(int i = startIndex+1; i <= input.length(); i++) {
            if(isPalindrome(input.substring(startIndex, i))) {
                output.add(input.substring(startIndex, i));
            }
        }
        return output;
    }

    // Using BFS instead of DfS
    public List<List<String>> partition(String s) {
        Queue<List<String>> queue = new LinkedList<List<String>>();
        Queue<Integer> lenQueue = new LinkedList<Integer>();
        List<List<String>> output = new ArrayList<List<String>>();

        List<String> tmpList = findPalindromes(s, 0);
        List<String> list = null;
        for(String tmp : tmpList) {
            list = new ArrayList<String>();
            list.add(tmp);
            queue.add(list);
            lenQueue.add(tmp.length());
        }
        int existingLength = 0;
        while(!queue.isEmpty()) {
            list = queue.remove();
            existingLength = lenQueue.remove();
            if(existingLength == s.length()) {
                output.add(list);
            } else {
                tmpList = findPalindromes(s, existingLength);
                for(String tmp : tmpList) {
                    List<String> newList = new ArrayList<String>(list);
                    newList.add(tmp);
                    queue.add(newList);
                    lenQueue.add(existingLength + tmp.length());
                }
            }
        }
        return output;
    }
}
