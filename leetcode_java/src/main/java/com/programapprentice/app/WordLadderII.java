package com.programapprentice.app;

/**
 * User: ruijiang
 * Date: 8/28/14
 * Time: 7:52 PM
 */

import java.util.*;

/**
 * Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:
 *
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * For example,
 *
 * Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * Return
 * [
 * ["hit","hot","dot","dog","cog"],
 * ["hit","hot","lot","log","cog"]
 * ]
 * Note:
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.*/
public class WordLadderII {
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> output = new ArrayList<List<String>>();
        if(dict.size() == 0) {
            return output;
        }
        Queue<String> wordQueue = new LinkedList<String>();
        Queue<Integer> depthQueue = new LinkedList<Integer>();
        Queue<List<String>> recordQueue = new LinkedList<List<String>>();
        Queue<Set<String>> dictQueue = new LinkedList<Set<String>>();

        wordQueue.add(start);
        depthQueue.add(1);
        List<String> tmpList = new ArrayList<String>();
        tmpList.add(start);
        recordQueue.add(tmpList);
        dictQueue.add(dict);

        String curWord = null;
        String newWord = null;
        int depth = 0;
        int minDepth = dict.size() + 1;
        Set<String> tmpDict = null;
        while(!wordQueue.isEmpty()) {
            curWord = wordQueue.remove();
            depth = depthQueue.remove();
            tmpList = recordQueue.remove();
            tmpDict = dictQueue.remove();

            if(depth >= minDepth) {
                continue;
            }
            for(int i = 0; i < curWord.length(); i++) {
                char[] wordArray = curWord.toCharArray();
                for(char c = 'a'; c <= 'z'; c++) {
                    wordArray[i] = c;
                    newWord = new String(wordArray);
                    if(newWord.equals(end)) {
                        tmpList.add(newWord);
                        minDepth = depth + 1 < minDepth ? depth + 1 : minDepth;
                        output.add(tmpList);
                        continue;
                    }
                    if(tmpDict.contains(newWord)) {
                        Set<String> newDict = new HashSet<String>(tmpDict);
                        List<String> newList = new ArrayList<String>(tmpList);
                        newDict.remove(newWord);
                        newList.add(newWord);

                        wordQueue.add(newWord);
                        depthQueue.add(depth + 1);
                        dictQueue.add(newDict);
                        recordQueue.add(newList);
                    }
                }
            }
        }
        return output;
    }
}
