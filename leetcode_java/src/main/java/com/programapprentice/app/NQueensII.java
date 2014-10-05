package com.programapprentice.app;

import java.util.LinkedList;

/**
 * User: ruijiang
 * Date: 10/5/14
 * Time: 3:08 AM
 */
public class NQueensII {
    public int totalNQueens(int n) {
        int outputSize = 0;
        LinkedList<Integer> positions = new LinkedList<Integer>();
        positions.add(0);
        boolean[][] matrix = new boolean[n][n];
        boolean[] rowOccupied = new boolean[n];
        boolean[] colOccupied = new boolean[n];
        int row = 0;
        int col = 0;
        boolean found = false;

        while(!positions.isEmpty()) {
            row = positions.size() - 1;
            col = positions.getLast();
            found = false;
            if(col < n) {
                for (int validCol = col; validCol < n; validCol++) {
                    if (isAvailable(n, row, validCol, rowOccupied, colOccupied, matrix)) {
                        positions.set(positions.size()-1, validCol);
                        rowOccupied[row] = true;
                        colOccupied[validCol] = true;
                        matrix[row][validCol] = true;
                        found = true;
                        if(row == n-1) {
                            // add one solution to output
                            outputSize++;
                            rowOccupied[row] = false;
                            colOccupied[validCol] = false;
                            matrix[row][validCol] = false;
                            found = false;
                        } else {
                            positions.addLast(0);
                            break;
                        }

                    }
                }
            }
            if(found) {
                continue;
            } else {
                positions.removeLast();
                if(!positions.isEmpty()) {
                    row = positions.size() - 1;
                    col = positions.getLast();
                    rowOccupied[row] = false;
                    colOccupied[col] = false;
                    matrix[row][col] = false;
                    positions.set(row, col + 1);
                }
            }

        }

        return outputSize;
    }

        // row and col start with 0
    public boolean isAvailable(int n, int row, int col, boolean[] rowOcuppied,
                               boolean[] colOccupied, boolean[][] matrix) {
        if(colOccupied[col] || rowOcuppied[row]) {
            return false;
        }
        int trow = row;
        int tcol = col;

        // left up
        do {
            if(matrix[trow][tcol]) {
                return false;
            }
            trow--;
            tcol--;
        } while(trow >= 0 && tcol >= 0);

        // right down
        trow = row;
        tcol = col;
        do {
            if(matrix[trow][tcol]) {
                return false;
            }
            trow++;
            tcol++;
        } while(trow < n && tcol < n);

        // right up
        trow = row;
        tcol = col;
        do {
            if(matrix[trow][tcol]) {
                return false;
            }
            trow--;
            tcol++;
        } while(trow >= 0 && tcol < n);

        // left down
        trow = row;
        tcol = col;
        do {
            if(matrix[trow][tcol]) {
                return false;
            }
            trow++;
            tcol--;
        } while(trow < n && tcol >= 0);

        return true;
    }

}
