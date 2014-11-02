package com.programapprentice.app;

/**
 * User: ruijiang
 * Date: 10/27/14
 * Time: 7:56 AM
 */
// a very good reference:
// http://blog.csdn.net/linhuanmars/article/details/20089131
public class SqrtX {
    public int sqrt(int x) {
        if(x < 0) {
            return -1;
        }
        if(x == 0 || x == 1) {
            return x;
        }
        int low = 1;
        int high = x / 2 + 1; // sqrt will not exceed x/2+1
        int middle = 0;
        while(low <= high) {
            middle = (low + high) / 2;
            if((x/middle >= middle) && (x / (middle+1) < (middle+1))) {
                return middle;
            }
            if(x/middle > middle) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return 0;
    }
}
