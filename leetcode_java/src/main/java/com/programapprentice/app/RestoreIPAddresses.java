package com.programapprentice.app;

/**
 * @author rjiang
 * @date 8/26/14
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 *
 * For example:
 * Given "25525511135",
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 * */

public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> output = new ArrayList<String>();
        String tmp = null;
        Set<String> outputSet = new HashSet<String>();
        Set<String> tmpSet = new HashSet<String>();
        int maxLength = s.length() > 3 ? 3 : s.length();
        for(int i = 0; i < maxLength; i++) {
            tmp = s.substring(0, i+1);
            if(tmp.length() > 1) {
                if(tmp.charAt(0) == '0') {
                    break;
                }
            }
            if(Integer.valueOf(tmp) <= 255 && Integer.valueOf(tmp) >= 0) {
                tmpSet = restoreIpAddresses(s.substring(i + 1), 3);
                for(String so : tmpSet) {
                    outputSet.add(tmp + so);
                }
            }
        }
        output.addAll(outputSet);
        return output;
    }

    // need to get #num addresses
    public Set<String> restoreIpAddresses(String s, int num) {
        Set<String> output = new HashSet<String>();
        if(1 == num) {
            if(s.length() > 1 && s.charAt(0) == '0') {
                return output;
            }
            if(s.length() > 0 && s.length() <= 3 && Integer.valueOf(s) <= 255 && Integer.valueOf(s) >= 0) {
                output.add("." + s);
            }
            return output;
        }

        String tmp = null;
        Set<String> subOutput = new HashSet<String>();
        int maxLength = s.length() > 3 ? 3 : s.length();
        for(int i = 0; i < maxLength; i++) {
            tmp = s.substring(0, i+1);
            if(tmp.length() > 1) {
                if(tmp.charAt(0) == '0') {
                    break;
                }
            }
            if(Integer.valueOf(tmp) <= 255 && Integer.valueOf(tmp) >= 0) {
                subOutput = restoreIpAddresses(s.substring(i + 1), num - 1);
                for(String so : subOutput) {
                    output.add("." + tmp + so);
                }
            }
        }
        return output;
    }


}
