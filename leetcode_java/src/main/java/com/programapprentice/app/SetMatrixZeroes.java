package com.programapprentice.app;

/**
 * User: ruijiang
 * Date: 1/12/15
 * Time: 12:30 PM
 */

/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0.
 * Do it in place.
 */
public class SetMatrixZeroes {
    // the idea should be using row 0 and col 0 to store the status
    // go through matrix twice
    // first round set the zeroIndicator, row 0, and col 0
    // set the corresponding place as zero
    public void setZeroes(int[][] matrix) {
        if(null == matrix || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        boolean colZero = false;
        boolean rowZero = false;
        int height = matrix.length;
        int width = matrix[0].length;

        // check row 0
        for(int i = 0; i < width; i++) {
            if(matrix[0][i] == 0) {
                rowZero = true;
                break;
            }
        }

        // check col 0
        for(int i = 0; i < height; i++) {
            if(matrix[i][0] == 0) {
                colZero = true;
                break;
            }
        }

        // check other elements
        for(int i = 1; i < height; i++) {
            for(int j = 1; j < width; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // set zeros
        for(int i = 1; i < height; i++) {
            for(int j = 1; j < width; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0 ) {
                    matrix[i][j] = 0;
                }
            }
        }

        // set row 0
        if(rowZero) {
           for(int i = 0; i < width; i++) {
               matrix[0][i] = 0;
           }
        }

        // set col 0
        if(colZero) {
            for(int i = 0; i < height; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
