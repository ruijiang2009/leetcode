package com.programapprentice.app;

/**
 * Created with IntelliJ IDEA.
 * User: ruijiang
 * Date: 8/2/14
 * Time: 11:50 PM
 */

/**
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 *
 * Note:
 * You may not engage in multiple transactions at the same time
 * (ie, you must sell the stock before you buy again).
 */
public class BestTimeToBuyAndSellStockIII {

    public int maxProfitFailed(int[] prices) {
        int[] top2Max = new int[2]; // [0] will be biggest gain, [1] will be the second
        top2Max[0] = 0;
        top2Max[1] = 0;

        if(prices == null || prices.length == 0 || prices.length == 1) {
            return 0;
        }

        boolean isUp = false;
        int buy = prices[0];
        int profit = 0;
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] > prices[i-1]) {
                if(isUp == false) {
                    buy = prices[i-1];
                }
                isUp = true;
            } else {
                if(isUp == true) {
                    if(-1 != buy) {
                        profit = prices[i-1] - buy;
                        if(profit > top2Max[0]) {
                            top2Max[1] = top2Max[0];
                            top2Max[0] = profit;
                        } else if(profit == top2Max[0]) {
                            top2Max[1] = profit;
                        } else {
                            top2Max[1] = top2Max[1] < profit ? profit : top2Max[1];
                        }
                        buy = -1;
                    }
                }
                isUp = false;
            }
        }
        if(-1 != buy) {
            profit = prices[prices.length - 1] - buy;
            if(profit > top2Max[0]) {
                top2Max[1] = top2Max[0];
                top2Max[0] = profit;
            } else if(profit == top2Max[0]) {
                top2Max[1] = profit;
            } else {
                top2Max[1] = top2Max[1] < profit ? profit : top2Max[1];
            }
        }

        return top2Max[0] + top2Max[1];
    }

    public int maxProfitTooSlow(int[] prices) {
        if(prices == null || prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int max = 0;
        for(int i = 0; i < prices.length; i++) {
            int tmp = maxProfit(prices, 0,i) + maxProfit(prices, i, prices.length-1);
            max = max > tmp ? max : tmp;
        }
        return max;
    }

    public int maxProfit(int[] prices, int startIndex, int endIndex) {
        if(startIndex >= endIndex) {
            return 0;
        }
        int max = 0;
        int start = prices[startIndex];
        int end = Integer.MIN_VALUE;
        for(int i = startIndex + 1; i <= endIndex; i++) {
            if(end == Integer.MIN_VALUE) {
                if(prices[i] < start) {
                    start = prices[i];
                } else {
                    end = prices[i];
                    max = max > (end - start) ? max : end - start;
                }
            } else {
                if(end <= prices[i]) {
                    end = prices[i];
                    max = max > (end - start) ? max : end - start;
                } else {
                    if (start > prices[i]) {
                        start = prices[i];
                        end = Integer.MIN_VALUE;
                    }
                }
            }
        }
        return max;
    }


    /** time complexity: O(n) */
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0 || prices.length == 1) {
            return 0;
        }

        int[] left = new int[prices.length];
        int[] right = new int[prices.length];

        getRecord(prices, left, right);
        int max = 0;
        for(int i = 0; i < prices.length; i++) {
            max = max > (left[i] + right[i]) ? max : (left[i] + right[i]);
        }
        return max;
    }

    public void getRecord(int[] prices, int[] left, int[] right) {
        left[0] = 0;

        int min = prices[0];
        int mp = 0;
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] < prices[i-1]) {
                min = min < prices[i] ? min : prices[i];
                left[i] = left[i-1];
            } else if(prices[i] > prices[i-1]){
                mp = mp > (prices[i] - min) ? mp : (prices[i] - min);
                left[i] = mp;
            } else {
                left[i] = left[i-1];
            }
        }

        right[prices.length - 1] = 0;
        int max = prices[prices.length - 1];
        mp = 0;
        for(int i = prices.length - 2; i >= 0; i--) {
            if(prices[i] < prices[i+1]) {
                mp = mp > (max - prices[i]) ? mp : (max - prices[i]);
                right[i] = mp;
            } else if(prices[i] > prices[i+1]) {
                max = max > prices[i] ? max : prices[i];
                right[i] = right[i+1];
            } else {
                right[i] = right[i+1];
            }
        }
    }
}
