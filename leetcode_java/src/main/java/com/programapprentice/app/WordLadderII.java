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
    public List<List<String>> findLaddersV3(String start, String end, Set<String> dict) {
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

    public List<List<String>> findLaddersV4(String start, String end, Set<String> dict) {
        long startTime = System.currentTimeMillis();
        List<List<String>> output = new ArrayList<List<String>>();
        if(dict.size() == 0) {
            return output;
        }

        Queue<String> wordQueue = new LinkedList<String>();
        HashMap<String, Set<String>> preMap = new HashMap<String, Set<String>>();
        wordQueue.add(start);

        Set<String> tmpSet = null;
        String newWord = null;
        int depth = 1;
        int minDepth = dict.size() + 1;
        int countLevel = 1; // how many words are added in queue for this level
        List<String> curLevelList = null;
        while(!wordQueue.isEmpty()) {
            if(depth >= minDepth) {
                break;
            }
            curLevelList = new ArrayList<String>();
            for(int i = 0; i < countLevel; i++) {
                String word = wordQueue.remove();
                curLevelList.add(word);
                if(dict.contains(word)) {
                    dict.remove(word);
                }
            }
            countLevel = 0;
            for(String curWord : curLevelList) {
                for(int j = 0; j < curWord.length(); j++) {
                    char[] wordArray = curWord.toCharArray();
                    for(char c = 'a'; c <= 'z'; c++) {
                        wordArray[j] = c;
                        newWord = new String(wordArray);
                        if(newWord.equals(end)) {
                            tmpSet = preMap.get(newWord);
                            if(null == tmpSet) {
                                tmpSet = new HashSet<String>();
                            }
                            tmpSet.add(curWord);
                            preMap.put(newWord, tmpSet);
                            wordQueue.add(newWord);
                            countLevel++;
                            if(newWord.equals(end)) {
                                minDepth = depth + 1 < minDepth ? depth + 1 : minDepth;
                            }
                        } else if(dict.contains(newWord)) {
                            tmpSet = preMap.get(newWord);
                            if(null == tmpSet) {
                                tmpSet = new HashSet<String>();
                            }
                            tmpSet.add(curWord);
                            preMap.put(newWord, tmpSet);
                            wordQueue.add(newWord);
                            countLevel++;
                            if(newWord.equals(end)) {
                                minDepth = depth + 1 < minDepth ? depth + 1 : minDepth;
                            }
                        }
                    }
                }
            }
            depth++;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("before get paths " + (endTime - startTime) + " ms");
        // after create all the preMap, generate output from that map.
        output = getPaths(start, end, preMap);
        return output;
    }

    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
//        long startTime = System.currentTimeMillis();
        List<List<String>> output = new ArrayList<List<String>>();
        if(dict.size() == 0) {
            return output;
        }

        Queue<String> wordQueue = new LinkedList<String>();
        Queue<Integer> depthQueue = new LinkedList<Integer>();
        HashMap<String, Set<String>> nextMap = new HashMap<String, Set<String>>();
        wordQueue.add(end);
        depthQueue.add(1);

        Set<String> tmpSet = null;
        String newWord = null;
        int depth = 1;
        int minDepth = dict.size() + 1;
        int preDepth = 1;
        HashSet<String> visitedCurLevel = new HashSet<String>();

        String curWord = null;
        while(!wordQueue.isEmpty()) {
            curWord = wordQueue.remove();
            depth = depthQueue.remove();
            if(depth >= minDepth) {
                break;
            }
            if (depth > preDepth) {
                dict.removeAll(visitedCurLevel);
                visitedCurLevel = new HashSet<String>();
            }
            preDepth = depth;
            for(int i = 0; i < curWord.length(); i++)  {
                char[] wordArray = curWord.toCharArray();
                for(char c = 'a'; c <= 'z'; c++) {
                    wordArray[i] = c;
                    newWord = new String(wordArray);
                    if(newWord.equals(start)) {
                        minDepth = depth + 1 < minDepth ? depth + 1 : minDepth;
                        tmpSet = nextMap.get(newWord);
                        if(tmpSet == null) {
                            tmpSet = new HashSet<String>();
                        }
                        tmpSet.add(curWord);
                        nextMap.put(newWord, tmpSet);
                        break;
                    } else if(!curWord.equals(newWord) && dict.contains(newWord)) {
                        tmpSet = nextMap.get(newWord);
                        if(tmpSet == null) {
                            tmpSet = new HashSet<String>();
                        }
                        tmpSet.add(curWord);
                        nextMap.put(newWord, tmpSet);
                        if(visitedCurLevel.add(newWord)) {
                            wordQueue.add(newWord);
                            depthQueue.add(depth + 1);
                        }
                    }
                }
            }
        }
//        long endTime = System.currentTimeMillis();
//        printMap(nextMap);
//        System.out.println("before get paths " + (endTime - startTime) + " ms");
        // after create all the preMap, generate output from that map.
        output = getPathsV2(start, end, nextMap);
        return output;
    }

    public List<List<String>> getPathsV2(String start, String end, HashMap<String, Set<String>> map) {

        List<List<String>> output = new ArrayList<List<String>>();
        if(!map.containsKey(start) || map.get(start).size() == 0) {
            // there is no such conversion from start to end
            return output;
        }

        List<String> path = new ArrayList<String>();
        path.add(start);
        Queue<List<String>> pathQueue = new LinkedList<List<String>>();
        pathQueue.add(path);
        Set<String> nextList = null;
        while(!pathQueue.isEmpty()) {
            path = pathQueue.remove();
            nextList = map.get(path.get(path.size() - 1));
            if(nextList == null) {
                continue;
            }
            for (String word : nextList) {
                List<String> newPath = new ArrayList<String>(path);
                newPath.add(word);
                if(word.equals(end)) {
                    output.add(newPath);
                } else {
                    if(map.get(word) != null) {
                        pathQueue.add(newPath);
                    }
                }
            }

        }
        return output;
    }

    class Node {
        LinkedList<String> path;
        Set<String> preList;

        public Node(LinkedList<String> path, Set<String> preList) {
            this.path = path;
            this.preList = preList;
        }
    }
    public List<List<String>> getPaths(String start, String end, HashMap<String, Set<String>> map) {

        List<List<String>> output = new ArrayList<List<String>>();
        if(!map.containsKey(end) || map.get(end).size() == 0) {
            // there is no such conversion from start to end
            return output;
        }
        Set<String> preList = map.get(end);
        Queue<Node> queue = new LinkedList<Node>();
        LinkedList<String> path = new LinkedList<String>();
        path.add(end);
        Node node = new Node(path, preList);
        queue.add(node);

        Node headNode = null;
        while(!queue.isEmpty()) {
            headNode = queue.remove();
            path = headNode.path;
            preList = headNode.preList;
            for (String word : preList) {
                LinkedList<String> newPath = new LinkedList<String>(path);
                newPath.addFirst(word);
                if(word.equals(start)) {
                    output.add(newPath);
                } else {
                    if(map.get(word) != null) {
                        queue.add(new Node(newPath, map.get(word)));
                    }
                }
            }

        }
        return output;
    }

    public void printMapList(Map<String, List<String>> map) {
        for(String key : map.keySet()) {
            List<String> list = map.get(key);
            System.out.print(key + " : ");
            for(String word : list) {
                System.out.print(word + '\t');
            }
            System.out.println("");
        }
    }

    public void printMap(HashMap<String, Set<String>> map) {
        for(String key : map.keySet()) {
            Set<String> list = map.get(key);
            System.out.print(key + " : ");
            for(String word : list) {
                System.out.print(word + "    ");
            }
            System.out.println("");
        }
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
//        printMapList(nextMap);
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