package com.programapprentice.app;

/**
 * @author rjiang
 * @date 10/7/14
 */
/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 *
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 *
 * The replacement must be in-place, do not allocate extra memory.
 *
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * */

public class NextPermutation {
    public void nextPermutation(int[] num) {
        if(num == null || num.length < 2) {
            return;
        }
        int length = num.length;
        int tmp;
        if(num[length-1] > num[length-2]) {
            tmp = num[length-1];
            num[length-1] = num[length-2];
            num[length-2] = tmp;
            return;
        }

        int i = length-2;
        for(; i >= 0 ; i--) {
            if(num[i] < num[i+1]) {
                break;
            }
        }
        if (i >= 0) {
            tmp = num[i];
            int j = length - 1;
            for (; j > i; j--) {
                if (num[j] > tmp) {
                    break;
                }
            }
            // swap num[i] and num[j]
            num[i] = num[j];
            num[j] = tmp;
        }

        // reverse num[i..length-1]
        int high = length - 1;
        int low = i >= 0 ? i + 1 : 0;
        while(low < high) {
            tmp = num[high];
            num[high] = num[low];
            num[low] = tmp;
            high --;
            low ++;
        }
    }

    public void nextPermutationSolution(int[] num) {
        if(num == null || num.length == 0 || num.length ==1) {
            return;
        }
        // find the partition number
        int partitionIdx = -1;
        int n = num.length;
        for(int i = n-1; i > 0; i--) {
            if(num[i] > num[i-1]) {
                partitionIdx = i-1;
                break;
            }
        }

        int low = 0;
        int high = n-1;
        int tmp;
        if(partitionIdx != -1) {
            for(int i = n-1; i >= partitionIdx; i--) {
                if(num[i] > num[partitionIdx] ) {
                    // swap partition number and change number
                    tmp = num[partitionIdx];
                    num[partitionIdx] = num[i];
                    num[i] = tmp;
                    low = partitionIdx + 1;
                    break;
                }
            }
        }

        // swap from low to high
        while(low < high) {
            tmp = num[high];
            num[high] = num[low];
            num[low] = tmp;
            high --;
            low ++;
        }
    }
}

// reference: http://www.lifeincode.net/programming/leetcode-next-permutation-java/
// http://fisherlei.blogspot.com/2012/12/leetcode-next-permutation.html
