package com.programapprentice.app;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rjiang
 * @date 8/15/14
 */

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 *
 * For example,
 * Given the following matrix:
 *
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * You should return [1,2,3,6,9,8,7,4,5].
 * */

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix == null) {
            return new ArrayList<Integer>();
        }
        int height = matrix.length;
        if(height == 0) {
            return new ArrayList<Integer>();
        }
        if(matrix[0] == null) {
            return new ArrayList<Integer>();
        }
        int width = matrix[0].length;

        if(height == 1 || width == 1) {
            return spiralOrder(matrix, 0, 0, height, width);
        }

        List<Integer> output = new ArrayList<Integer>();
        int numOfRound = height/2 > width/2 ? width/2 : height/2;
        int row, col, subHeight, subWidth;
        for(int i = 0; i < numOfRound; i++) {
            row = i;
            col = i;
            subHeight = height - (2*i);
            subWidth = width - (2 * i);
            output.addAll(spiralOrder(matrix, row, col, subHeight, subWidth));
        }
        // handle the left
        int heightLeft = height - numOfRound * 2;
        int widthLeft = width - numOfRound * 2;
        if(heightLeft == 1) {
            for(int i = 0; i < widthLeft; i++) {
                output.add(matrix[numOfRound][numOfRound + i]);
            }
        }  else {
            if(widthLeft != 0) {
                for (int i = 0; i < heightLeft; i++) {
                    output.add(matrix[numOfRound + i][numOfRound]);
                }
            }
        }
        return output;
    }

    public List<Integer> spiralOrder(int[][] matrix,
             int row, int col,
             int height, int width) {
        List<Integer> output = new ArrayList<Integer>();
        if(height == 1 || width == 1) {
            for(int i = row; i < row + height ; i++) {
                for(int j = col; j < col + width; j++) {
                    output.add(matrix[i][j]);
                }
            }
            return output;
        }

        // from left to right
        for(int i = 0; i < width - 1; i++) {
            output.add(matrix[row][col + i]);
        }

        // from up to down
        for(int i = 0; i < height - 1; i++) {
            output.add(matrix[row+i][col+width-1]);
        }

        // from right to left
        for(int i = 0; i < width - 1; i++) {
            output.add(matrix[row+height-1][col+width-1-i]);
        }

        // from down to up
        for(int i = 0; i < height - 1; i++) {
            output.add(matrix[row+height-1-i][col]);
        }

        return output;
    }
}
