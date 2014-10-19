package com.programapprentice.app;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ruijiang
 * Date: 10/18/14
 * Time: 11:03 PM
 */

// reference http://www.cnblogs.com/springfor/p/3896201.html
public class PermutationSequence {
    public String getPermutation(int n, int k) {
        k --;
        List<Integer> numList = new ArrayList<Integer>();

        for(int i = 1; i <= n; i++) {
            numList.add(i);
        }

        int factorial = 1;
        for(int i = 2; i < n; i++) {
            factorial *= i;
        }

        StringBuilder res = new StringBuilder();
        int times = n - 1;
        while(times >= 0) {
            int indexInList = k / factorial;
            res.append(numList.get(indexInList));
            numList.remove(indexInList);

            k = k % factorial;
            if(times != 0) {
                factorial = factorial / times;
            }

            times --;
        }
        return res.toString();
    }
}
