package com.programapprentice.app;

/**
 * User: ruijiang
 * Date: 9/27/14
 * Time: 2:46 PM
 */

import java.util.*;

/**
 * You are given a string, S, and a list of words, L, that are all of the same length.
 * Find all starting indices of substring(s) in S that is a concatenation of each word
 * in L exactly once and without any intervening characters.
 *
 * For example, given:
 * S: "barfoothefoobarman"
 * L: ["foo", "bar"]
 * You should return the indices: [0,9].
 * (order does not matter).
 * */

public class SubstringWithConcatenationOfAllWords {

    public boolean isFinished(Map<String, Integer> unvisited ) {
        return unvisited.keySet().size() == 0;
    }

    public void moveWord(Map<String, Integer> src, Map<String, Integer> dst, String word) {
        Integer srcCounter = src.get(word);
        if(srcCounter == 1) {
            src.remove(word);
        } else {
            src.put(word, srcCounter - 1);
        }
        Integer dstCounter = dst.get(word);
        if(dstCounter == null) {
            dst.put(word, 1);
        } else {
            dst.put(word, dstCounter + 1);
        }
    }

    // this is too slow, didn't pass
    public List<Integer> findSubstringV1(String S, String[] L) {
        if(S == null || null == L || L.length == 0) {
            return new ArrayList<Integer>();
        }

        int wordLength = L[0].length();
        if(S.length() < L[0].length() * L.length) {
            return new ArrayList<Integer>();
        }

        HashMap<String, Integer> dict = new HashMap<String, Integer>();
        for(String str : L) {
            if(dict.get(str) == null) {
                dict.put(str, 1);
            } else {
                dict.put(str, dict.get(str) + 1);
            }
        }
        HashMap<String, Integer> visited = new HashMap<String, Integer>();
        HashMap<String, Integer> unvisited = (HashMap)dict.clone();
        List<Integer> output = new ArrayList<Integer>();
        int start = -1;
        int cursor  = 0;
        String word = null;
        String tmpWord = null;
        Integer unvisitedCounter = 0;
        while(cursor < S.length() && cursor + wordLength <= S.length()) {
            word = S.substring(cursor, cursor + wordLength);
            if(dict.get(word) != null) {
                unvisitedCounter = unvisited.get(word);
                if(unvisitedCounter != null) {
                    if(start == -1) {
                        start = cursor;
                    }
                    moveWord(unvisited, visited, word);
                    if(isFinished(unvisited)) {
                        output.add(start);
                        tmpWord = S.substring(start, start + wordLength);
                        moveWord(visited, unvisited, tmpWord);
                        start += wordLength;
                    }
                } else {
                    // has too many word
                    for(int i = start; i < cursor; i+= wordLength) {
                        tmpWord = S.substring(i, i + wordLength);
                        if(tmpWord.equals(word)) {
                            start = i + wordLength;
                            break;
                        } else {
                            moveWord(visited, unvisited, tmpWord);
                        }
                    }
                }
                cursor += wordLength;
            } else {
                visited = new HashMap<String, Integer>();
                unvisited = (HashMap)dict.clone();
                if(start == -1) {
                    cursor += 1;
                } else {
                    cursor = start + 1;
                }
                start = -1;
            }
        }

        return output;
    }

    // accepted: brute force
    public List<Integer> findSubstringV2(String S, String[] L) {
        if(S == null || null == L || L.length == 0) {
            return new ArrayList<Integer>();
        }

        int wordLength = L[0].length();
        if(S.length() < L[0].length() * L.length) {
            return new ArrayList<Integer>();
        }

        HashMap<String, Integer> dict = new HashMap<String, Integer>();
        for(String str : L) {
            if(dict.get(str) == null) {
                dict.put(str, 1);
            } else {
                dict.put(str, dict.get(str) + 1);
            }
        }
        List<Integer> output = new ArrayList<Integer>();

        String word;
        int start = 0;
        for(int i = 0; i < S.length(); i++) {
            Map<String, Integer> numMap = new HashMap<String, Integer>();
            int j = 0;
            for(; j < L.length; j++) {
                start = i + j * wordLength;
                if(start + wordLength > S.length()) {
                    break;
                }
                word = S.substring(start, start + wordLength);
                if(!dict.containsKey(word)) {
                    break;
                }
                int num = 1;
                if(numMap.get(word) != null) {
                    num = numMap.get(word) + 1;
                }
                numMap.put(word, num);
                if(num > dict.get(word)) {
                    break;
                }
            }
            if(j == L.length) {
                output.add(i);
            }
        }
        return output;
    }

    public List<Integer> findSubstring(String S, String[] L) {
        if(S == null || null == L || L.length == 0) {
            return new ArrayList<Integer>();
        }

        int wordLength = L[0].length();
        if(S.length() < L[0].length() * L.length) {
            return new ArrayList<Integer>();
        }

        HashMap<String, Integer> dict = new HashMap<String, Integer>();
        for(String str : L) {
            if(dict.get(str) == null) {
                dict.put(str, 1);
            } else {
                dict.put(str, dict.get(str) + 1);
            }
        }
        List<Integer> output = new ArrayList<Integer>();
        int scanLength = S.length() - wordLength + 1;
        String word = null;
        String tmpWord = null;
        int num = 0;
        for(int i = 0; i < wordLength; i++) {
            Map<String, Integer> numMap = new HashMap<String, Integer>();
            int count = 0;
            int start = i;
            for(int j = i; j < scanLength; j += wordLength) {
                word = S.substring(j, j + wordLength);
                if(dict.containsKey(word)) {
                    num = 1;
                    if(numMap.containsKey(word)) {
                        num += numMap.get(word);
                    }
                    numMap.put(word, num);
                    if(num > dict.get(word)) {
                        do {
                            tmpWord = S.substring(start, start + wordLength);
                            numMap.put(tmpWord, numMap.get(tmpWord) - 1);
                            if(!tmpWord.equals(word)) {
                                count--;
                            }
                            start += wordLength;
                        } while(!tmpWord.equals(word));
                    } else {
                        count++;
                    }
                    if(count == L.length) {
                        output.add(start);
                        word = S.substring(start, start + wordLength);
                        numMap.put(word, numMap.get(word) - 1);
                        count--;
                        start += wordLength;
                    }
                } else {
                    start = j + wordLength;
                    numMap.clear();
                    count = 0;
                }
            }
        }

        return output;
    }

    // refer http://blog.csdn.net/u013027996/article/details/24795107
    public List<Integer> findSubstringSolution(String S, String[] L) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int len = L.length;
        if (len == 0) {
            return list;
        }
        int wordLen = L[0].length();
        Map<String, Integer> wordsMap = new HashMap<String, Integer>();
        for (int i = 0; i < len; i++) {
            int num = 1;
            if (wordsMap.get(L[i]) != null) {
                num += wordsMap.get(L[i]);
            }
            wordsMap.put(L[i], num);
        }
        int slen = S.length();
        int max = slen - wordLen + 1;
        for (int i = 0; i < wordLen; i++) {
            Map<String, Integer> numMap = new HashMap<String, Integer>();
            int count = 0;
            int start = i;
            for (int end = start; end < max; end += wordLen) {
                String tempStr = S.substring(end, end + wordLen);
                if (!wordsMap.containsKey(tempStr)) {
                    numMap.clear();
                    count = 0;
                    start = end + wordLen;
                    continue;
                }
                int num = 1;
                if (numMap.containsKey(tempStr)) {
                    num += numMap.get(tempStr);
                }
                numMap.put(tempStr, num);
                if (num <= wordsMap.get(tempStr)) {
                    count++;
                } else {
                    while (numMap.get(tempStr) > wordsMap.get(tempStr)) {
                        tempStr = S.substring(start, start + wordLen);
                        numMap.put(tempStr, numMap.get(tempStr) - 1);
                        if (numMap.get(tempStr) < wordsMap.get(tempStr)) {
                            count--;
                        }
                        start += wordLen;
                    }
                }
                if (count == len) {
                    list.add(start);
                    tempStr = S.substring(start, start + wordLen);
                    numMap.put(tempStr, numMap.get(tempStr) - 1);
                    count--;
                    start += wordLen;
                }
            }
        }
        return list;
    }
}
