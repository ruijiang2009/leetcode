package com.programapprentice.app;

/**
 * Created with IntelliJ IDEA.
 * User: ruijiang
 * Date: 8/1/14
 * Time: 10:10 PM
 */

/**
 * There are N children standing in a line. Each child is assigned a rating value.

 * You are giving candies to these children subjected to the following requirements:
 *
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 * */

public class Candy {
    public int candy(int[] ratings) {
        if(ratings == null) {
            return 0;
        }
        if(ratings.length == 1) {
            return 1;
        }

        int[] candies = new int[ratings.length];
        candies[0] = 1;
        for(int i = 1; i < ratings.length; i++) {
            if(ratings[i-1] > ratings[i]) {
                candies[i] = 1;
                for(int j = i-1; j >= 0; j--) {
                    if(ratings[j] > ratings[j+1]) {
                        if(candies[j] > candies[j+1]) {
                            continue;
                        } else {
                            candies[j]++;
                        }
                    } else if(ratings[j] < ratings[j+1]) {
                        break;
                    } else {
                        break;
                    }
                }
            } else if(ratings[i-1] < ratings[i]) {
                candies[i] = candies[i-1] + 1;
            } else {
                candies[i] = 1;
            }
        }
        int sum = 0;
        for(int i = 0; i < candies.length; i++) {
            sum += candies[i];
        }
        return sum;
    }
}
