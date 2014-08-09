package com.programapprentice.app;

/**
 * Created with IntelliJ IDEA.
 * User: ruijiang
 * Date: 8/8/14
 * Time: 5:34 PM
 */
/**
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 *
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to
 * its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
 *
 * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 *
 * Note:
 * The solution is guaranteed to be unique.
 */
public class GasStation {

    // Time complexity: O(n^2)
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int cur = 0;
        int i, j;
        for(i = 0; i < n; i++) {
            cur = 0;
            for(j = 0; j < n; j++) {
                cur = cur + gas[(i + j) % n] - cost[(i + j) % n];
                if(cur < 0) {
                    break;
                }
            }
            if(j == n) {
                return i;
            }
        }
        return -1;
    }
}
