package com.programapprentice.app;

/**
 * User: ruijiang
 * Date: 11/2/14
 * Time: 12:08 AM
 */
/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 *
 * Find the minimum element.
 * The array may contain duplicates.
 * */
// reference http://blog.csdn.net/linhuanmars/article/details/40449299
public class FindMinimuminRotatedSortedArrayII {
    public int findMinV2(int[] num) {
        if(num == null) {
            return 0;
        }
        int low = 0;
        int high = num.length - 1;
        int mid = 0;
        int midlow = 0;
        int midhigh = 0;
        while(low <= high) {
            mid = (low + high) / 2;
            midlow = (mid - 1 + num.length) % num.length;
            midhigh = (mid + 1) % num.length;
            if(num[midlow] > num[mid] && num[midhigh] >= num[mid]) {
                return num[mid];
            }
            if(num[mid] > num[low]) {
                low = midhigh;
            } else if(num[mid] < num[low]){
                high = midlow;
            } else {
                // num[mid] == num[low]
                low = midhigh;
            }
//            if(num[midlow] > num[mid] && num[midhigh] >= num[mid]) {
//                return num[mid];
//            }
//            if()
//            if(num[mid] > num[high]) {
//                low = midhigh;
//            } else {
//                high = midlow;
//            }
        }
        return num[mid];
    }

    public int findMin(int[] num) {
        if(num == null || num.length == 0) {
            return 0;
        }
        if(num.length ==1) {
            return num[0];
        }
        if(num[0] < num[num.length - 1]) {
            return num[0];
        }
        int low = 0;
        int high = num.length - 1;
        int mid = 0;
        int midlow = 0;
        int midhigh = 0;
        while(low <= high) {
            mid = (low + high) / 2;
            midlow = (mid - 1 + num.length) % num.length;
            midhigh = (mid + 1) % num.length;

            if(num[midlow] > num[mid] && num[midhigh] >= num[mid]) {
                break;
            }
            if(num[mid] > num[low]) {
                if(num[mid] > num[high]) {
                    low = mid + 1;
                } else if (num[mid] < num[high]) {
                    high = mid - 1;
                } else {
                    // num[mid] == num[high]
                    high--;
                }
//                low = mid + 1;
//                low = midhigh;
//                low = mid;
            } else if(num[mid] < num[low]){
                if(num[mid] > num[high]) {
                    low = mid + 1;
                } else if(num[mid] < num[high]) {
                    high = mid - 1;
                } else {
                    // num[mid] == num[high]
                    low++;
                }
//                high = mid - 1;
//                high = midlow;
//                high = mid;
//                low = mid + 1;
            } else {
                // num[mid] == num[low]
                low++;
            }
        }
        return num[mid];
    }
}
