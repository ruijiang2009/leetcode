package com.programapprentice.app;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author rjiang
 * @date 8/7/14
 */
public class LongestConsecutiveSequence {


    /**
     * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

     * For example,
     * Given [100, 4, 200, 1, 3, 2],
     * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
     *
     * Your algorithm should run in O(n) complexity.
     * */
    public int longestConsecutiveFailed(int[] num) {
        HashMap<Integer, Integer> downMap = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> upMap = new HashMap<Integer, Integer>();
        Set<Integer> existingSet = new HashSet<Integer>();

        int cur = 0;
        for(int i = 0; i < num.length; i++) {
            cur = num[i];
            if(existingSet.contains(cur)) {
                continue;
            }
            existingSet.add(cur);

            int len = 0;
            Integer prelen = null;

            if(downMap.get(cur) != null && upMap.get(cur) != null) {
                // merge case
                int down = downMap.get(cur);
                int up = upMap.get(cur);
                int newlen = up + down + 1;
                prelen = downMap.get(cur - up - 1);
                if(prelen != null) {
                    newlen = prelen > newlen ? prelen : newlen;
                }
                downMap.put(cur - up - 1, newlen);

                newlen = up + down + 1;
                prelen = upMap.get(cur + down + 1);
                if(prelen != null) {
                    newlen= prelen > newlen ? prelen : newlen;
                }
                upMap.put(cur + down + 1, newlen);
            } else {
                if (downMap.get(cur) == null) {
                    len = 1;
                } else {
                    len = downMap.get(cur);
                    len++;
                }
                if(existingSet.contains(cur-1)) {
                    Integer downlen = downMap.get(cur-2);
                    len += downlen;
                    downMap.put(cur-2, downlen);
                } else {

                }
                prelen = downMap.get(cur - 1);
                if (prelen != null) {
                    len = len > prelen ? len : prelen;
                }
                downMap.put(cur - 1, len);

                if (upMap.get(cur) == null) {
                    len = 1;
                } else {
                    len = upMap.get(cur);
                    len++;
                }
                if(existingSet.contains(cur + 1)) {
                    Integer uplen = upMap.get(cur + 2);
                    len += uplen;
                    downMap.put(cur, uplen);
                }
                prelen = upMap.get(cur + 2);
                if (prelen != null) {
                    len = len > prelen ? len : prelen;
                }
                upMap.put(cur + 1, len);
                
            }
        }

        int max = 0;
        for(Integer key : downMap.keySet()) {
            max = max > downMap.get(key) ? max : downMap.get(key);
        }

        for(Integer key : upMap.keySet()) {
            max = max > upMap.get(key) ? max : upMap.get(key);
        }

        return max;
    }

    public int longestConsecutive(int[] num) {
        int max = 0;
        Set<Integer> numSet = new HashSet<Integer>();
        for(int i = 0; i < num.length; i++) {
            numSet.add(num[i]);
        }

        int cur = 0;
        int len = 0;
        for(int i = 0; i < num.length; i++) {
            // up direction
            cur = num[i] + 1;
            len = 1;
            while(numSet.contains(cur)) {
                cur++;
                len++;
            }
            max = max > len ? max : len;

            // downdirection
            cur = num[i]-1;
            len = 1;
            while(numSet.contains(cur)) {
                cur--;
                len++;
            }
            max = max > len ? max : len;

            if(max == num.length) {
                break;
            }
        }

        return max;
    }

    // from the following link
    // https://oj.leetcode.com/discuss/6558/solution-of-mine-o-n-complexity-and-o-n-space-with-single-scan
    public int longestConsecutiveGoodExample(int[] num) {
        Map<Integer, Integer> sequence = new HashMap<Integer, Integer>();
        int longest = 0;
        for (int i = 0; i < num.length; i++) {
            if (sequence.containsKey(num[i])) continue;
            int lowerbound = num[i];
            int upperbound = num[i];
            if (sequence.containsKey(num[i] - 1)) // Get the lowerbound
                lowerbound = sequence.get(num[i] - 1);
            if (sequence.containsKey(num[i] + 1))// Get the Upperbound
                upperbound = sequence.get(num[i] + 1);
            longest = Math.max(longest, (upperbound - lowerbound)+ 1);
            sequence.put(num[i],num[i]);
            sequence.put(lowerbound, upperbound);
            sequence.put(upperbound, lowerbound);
        }
        return longest;
    }
}
