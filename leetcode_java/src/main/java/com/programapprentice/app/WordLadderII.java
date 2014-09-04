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
    // v1 is too slow
    public List<List<String>> findLaddersV1(String start, String end, Set<String> dict) {
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

    public List<List<String>> findLaddersV2(String start, String end, Set<String> dict) {
        List<List<String>> output = new ArrayList<List<String>>();
        if(dict.size() == 0) {
            return output;
        }

        Queue<String> wordQueue = new LinkedList<String>();
        Queue<List<String>> recordQueue = new LinkedList<List<String>>();
        Queue<Set<String>> setQueue = new LinkedList<Set<String>>();

        wordQueue.add(start);
        List<String> tmpList = new ArrayList<String>();
        tmpList.add(start);
        recordQueue.add(tmpList);
        Set<String> tmpSet = new HashSet<String>();
        tmpSet.add(start);
        setQueue.add(tmpSet);

        String curWord = null;
        String newWord = null;
        int depth = 0;
        int minDepth = dict.size() + 1;
        while(!wordQueue.isEmpty()) {
            curWord = wordQueue.remove();
            tmpList = recordQueue.remove();
            tmpSet = setQueue.remove();
            depth = tmpList.size();
            if (depth >= 2) {
                break;
            }
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
                    if(dict.contains(newWord) && !tmpSet.contains(newWord)) {
                        List<String> newList = new ArrayList<String>(tmpList);
                        newList.add(newWord);
                        Set<String> newSet = new HashSet<String>(newList);
                        wordQueue.offer(newWord);
                        recordQueue.offer(newList);
                        setQueue.offer(newSet);
                    }
                }
            }
        }
        return output;
    }

    // still too slow
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> output = new ArrayList<List<String>>();
        if(dict.size() == 0) {
            return output;
        }

        Queue<String> wordQueue = new LinkedList<String>();
        Queue<List<String>> recordQueue = new LinkedList<List<String>>();

        wordQueue.add(start);
        List<String> tmpList = new ArrayList<String>();
        tmpList.add(start);
        recordQueue.add(tmpList);

        String curWord = null;
        String newWord = null;
        int depth = 1;
        int minDepth = dict.size() + 1;
        int countLevel = 1;
        int newCountLevel = 0;
        while(!wordQueue.isEmpty()) {
            if(depth >= minDepth) {
                break;
            }
            for(int i = 0; i < countLevel; i++) {
                curWord = wordQueue.remove();
                if(dict.contains(curWord)) {
                    dict.remove(curWord);
                }
            }
            newCountLevel = 0;
            for(int i = 0; i < countLevel; i++) {
                tmpList = recordQueue.remove();
                curWord = tmpList.get(tmpList.size() - 1);
                for(int j = 0; j < curWord.length(); j++) {
                    char[] wordArray = curWord.toCharArray();
                    for(char c = 'a'; c <= 'z'; c++) {
                        wordArray[j] = c;
                        newWord = new String(wordArray);
                        if(newWord.equals(end)) {
                            List<String> newList = new ArrayList<String>(tmpList);
                            newList.add(newWord);
                            minDepth = depth + 1 < minDepth ? depth + 1 : minDepth;
                            output.add(newList);
                            continue;
                        }
                        if(dict.contains(newWord)) {
                            List<String> newList = new ArrayList<String>(tmpList);
                            newList.add(newWord);
                            wordQueue.offer(newWord);
                            recordQueue.offer(newList);
                            newCountLevel++;
                        }
                    }
                }
            }
            countLevel = newCountLevel;
            depth++;
        }
        return output;
    }

    //http://codeganker.blogspot.com/2014/04/word-ladder-ii-leetcode.html
    class StringWithLevel {
        String str;
        int level;
        public StringWithLevel(String str, int level) {
            this.str = str;
            this.level = level;
        }
    }
    public List<List<String>> findLaddersSolution(String start, String end, Set<String> dict) {
        List<List<String>> res = new ArrayList<List<String>>();
        HashSet<String> unvisitedSet = new HashSet<String>();
        unvisitedSet.addAll(dict);
        unvisitedSet.add(start);
        unvisitedSet.remove(end);
        Map<String, List<String>> nextMap = new HashMap<String, List<String>>();
        for (String e : unvisitedSet) {
            nextMap.put(e, new ArrayList<String>());
        }
        LinkedList<StringWithLevel> queue = new LinkedList<StringWithLevel>();
        queue.add(new StringWithLevel(end, 0));
        boolean found = false;
        int finalLevel = Integer.MAX_VALUE;
        int curLevel = 0;
        int preLevel = 0;
        HashSet<String> visitedCurLevel = new HashSet<String>();
        while (!queue.isEmpty()) {
            StringWithLevel cur = queue.poll();
            String curStr = cur.str;
            curLevel = cur.level;
            if(found && curLevel > finalLevel) {
                break;
            }
            if (curLevel > preLevel) {
                unvisitedSet.removeAll(visitedCurLevel);
            }
            preLevel = curLevel;
            char[] curStrCharArray = curStr.toCharArray();
            for (int i = 0; i < curStr.length(); ++i) {
                char originalChar = curStrCharArray[i];
                boolean foundCurCycle = false;
                for (char c = 'a'; c <= 'z'; ++c) {
                    curStrCharArray[i] = c;
                    String newStr = new String(curStrCharArray);
                    if(c != originalChar && unvisitedSet.contains(newStr)) {
                        nextMap.get(newStr).add(curStr);
                        if(newStr.equals(start)) {
                            found = true;
                            finalLevel = curLevel;
                            foundCurCycle = true;
                            break;
                        }
                        if(visitedCurLevel.add(newStr)) {
                            queue.add(new StringWithLevel(newStr, curLevel + 1));
                        }
                    }
                }
                if(foundCurCycle) {
                    break;
                }
                curStrCharArray[i] = originalChar;
            }
        }
        if(found) {
            ArrayList<String> list = new ArrayList<String>();
            list.add(start);
            getPaths(start, end, list, finalLevel + 1, nextMap, res);
        }
        return res;
    }
    private void getPaths(String cur, String end, ArrayList<String> list, int level, Map<String, List<String>> nextMap, List<List<String>> res) {
        if(cur.equals(end)){
            res.add(new ArrayList<String>(list));
        }
        else if(level > 0){
            List<String> parentsSet = nextMap.get(cur);
            for (String parent : parentsSet) {
                list.add(parent);
                getPaths(parent, end, list, level - 1, nextMap, res);
                list.remove(list.size() - 1);
            }
        }
    }
}
// other solution
// http://yucoding.blogspot.com/2014/01/leetcode-question-word-ladder-ii.html