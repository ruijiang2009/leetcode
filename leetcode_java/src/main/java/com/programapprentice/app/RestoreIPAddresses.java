package com.programapprentice.app;

/**
 * @author rjiang
 * @date 8/26/14
 */

import java.util.ArrayList;
import java.util.List;

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
        List<String> subOutput = new ArrayList<String>();
        int maxLength = s.length() > 3 ? 3 : s.length();
        for(int i = 0; i < maxLength; i++) {
            tmp = s.substring(0, i+1);
            if(Integer.valueOf(tmp) <= 255 && Integer.valueOf(tmp) >= 0) {
                subOutput = restoreIpAddresses(s.substring(i + 1), 3);
                for(String so : subOutput) {
                    output.add(tmp + so);
                }
            }
        }
        return output;
    }

    // need to get #num addresses
    public List<String> restoreIpAddresses(String s, int num) {
        List<String> output = new ArrayList<String>();
        if(1 == num) {
            if(s.length() > 0 && s.length() <= 3 && Integer.valueOf(s) <= 255 && Integer.valueOf(s) >= 0) {
                output.add("." + s);
            }
            return output;
        }

        String tmp = null;
        List<String> subOutput = new ArrayList<String>();
        int maxLength = s.length() > 3 ? 3 : s.length();
        for(int i = 0; i < maxLength; i++) {
            tmp = s.substring(0, i+1);
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
