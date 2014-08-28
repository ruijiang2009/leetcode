package com.programapprentice.app;

import java.util.Stack;

/**
 * User: ruijiang
 * Date: 8/27/14
 * Time: 7:09 PM
 */
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 ||  matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int height = matrix.length;
        int width = matrix[0].length;
        if(1 == height && 1 == width) {
            return matrix[0][0] - '0';
        }
        int[][] status = new int[height][width];
        int max = 0;
        int counter = 0;
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                if(i == 0) {
                    if(matrix[i][j] == '1') {
                        counter = 1;
                        for (int k = i + 1; k < height; k++) {
                            if(matrix[k][j] == '1') {
                                counter++;
                            } else {
                                break;
                            }
                        }
                        status[i][j] = counter;
                    }
                } else {
                    if(matrix[i-1][j] == '0') {
                        if(matrix[i][j] == '1') {
                            counter = 1;
                            for (int k = i + 1; k < height; k++) {
                                if (matrix[k][j] == '1') {
                                    counter++;
                                } else {
                                    break;
                                }
                            }
                            status[i][j] = counter;
                        }
                    } else {
                        status[i][j] = status[i-1][j] - 1;
                    }
                }
            }
        }
        int tmpMax = 0;
        for(int i = 0; i < height; i++) {
            tmpMax = largestRectangleArea(status[i]);
            max = max > tmpMax ? max : tmpMax;
        }
        return max;
    }

    public int largestRectangleArea(int[] height) {
        Stack<Integer> heightStack = new Stack<Integer>();
        Stack<Integer> indexStack = new Stack<Integer>();
        int maxArea = 0;
        int topHeight = 0;
        int recLen = 0;

        for(int i = 0; i < height.length; i++) {
            if(heightStack.isEmpty()) {
                heightStack.push(height[i]);
                indexStack.push(i);
            } else {
                while(!heightStack.isEmpty() && heightStack.peek() >= height[i]) {
                    topHeight = heightStack.pop();
                    indexStack.pop();
                    if(heightStack.isEmpty()) {
                        recLen = i;
                    } else {
                        recLen = i - indexStack.peek() - 1;
                    }
                    maxArea = maxArea > recLen * topHeight ? maxArea : recLen * topHeight;
                }
                heightStack.push(height[i]);
                indexStack.push(i);
            }
        }
        if(!heightStack.isEmpty()) {
            int[] leftHeight = new int[heightStack.size()];
            int[] leftIndex = new int[indexStack.size()];
            for(int i = leftHeight.length - 1; i >= 0; i--) {
                leftHeight[i] = heightStack.pop();
                leftIndex[i] = indexStack.pop();
            }
            for(int i = 0; i < leftHeight.length; i++) {
                topHeight = leftHeight[i];
                if(0 == i) {
                    recLen = height.length;
                } else {
                    recLen = height.length - leftIndex[i-1] - 1;
                }
                maxArea = maxArea > recLen * topHeight ? maxArea : recLen * topHeight;
            }
        }

        return maxArea;
    }
}
