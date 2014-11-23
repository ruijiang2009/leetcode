/*
 * find_minimum_in_rotated_sorted_array.cc
 *
 *  Created on: Nov 22, 2014
 *      Author: ruijiang
 */

#include "find_minimum_in_rotated_sorted_array.h"


int Solution::findMin(vector<int> &num){
    int length = num.size();
    if(0 == length) {
        return num[0];
    }
    int low = 0;
    int high = length - 1;
    int mid = 0;
    int midlow = 0;
    int midhigh = 0;
    while(low < high) {
        mid = (low + high) / 2;
        midlow = (length + mid - 1) % length;
        midhigh = (mid + 1) % length;
        if(num[midlow] > num[mid] && num[midhigh] > num[mid]) {
            return num[mid];
        }
        if(num[high] > num[low]) {
            if(num[high] > num[mid]) {
                high = midlow;
            } else {
                low = midhigh;
            }
        } else {
            if(num[high] > num[mid]) {
                high = midlow;
            } else {
                low = midhigh;
            }
        }
    }
    return num[low];
}


// http://www.cnblogs.com/forcheryl/p/4032278.html
//int Solution::findMin(vector<int> &num) {
//    int start=0,end=num.size()-1;
//
//    while (start<end) {
//        if (num[start]<num[end])
//            return num[start];
//
//        int mid = (start+end)/2;
//
//        if (num[mid]>=num[start]) {
//            start = mid+1;
//        } else {
//            end = mid;
//        }
//    }
//
//    return num[start];
//}
//
