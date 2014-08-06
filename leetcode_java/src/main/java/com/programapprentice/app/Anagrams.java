package com.programapprentice.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author rjiang
 * @date 8/6/14
 */
public class Anagrams {
    public String sortString(String input) {
        char[] chars = input.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }
    public List<String> anagrams(String[] strs) {
        HashMap<String, List<String>> anagramMap = new HashMap<String, List<String>>();
        String sortedStr = null;
        for(String str : strs) {
            sortedStr = sortString(str);
            List<String> content = anagramMap.get(sortedStr);
            if(content == null) {
                content = new ArrayList<String>();
            }
            content.add(str);
            anagramMap.put(sortedStr, content);
        }
        List<String> output = new ArrayList<String>();
        for(String key : anagramMap.keySet()) {
            List<String> content = anagramMap.get(key);
            if(content.size() > 1) {
                for(String cont : content) {
                    output.add(cont);
                }
            }
        }
        return output;
    }
}
