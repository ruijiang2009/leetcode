package com.programapprentice.app;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * User: ruijiang
 * Date: 10/4/14
 * Time: 10:35 PM
 */

/**
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 *
 * Each solution contains a distinct board configuration of the n-queens' placement,
 * where 'Q' and '.' both indicate a queen and an empty space respectively.
 *
 * For example,
 * There exist two distinct solutions to the 4-queens puzzle:
 *
 * [
 * [".Q..",  // Solution 1
 * "...Q",
 * "Q...",
 * "..Q."],
 *
 * ["..Q.",  // Solution 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 * */
public class NQueens {
    public List<String[]> solveNQueens(int n) {
        List<String[]> output = new ArrayList<String[]>();
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
                            output.add(convertOneSolution(positions, n));
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

        return output;
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

    public String[] convertOneSolution(LinkedList<Integer> positions, int n) {
        String[] output = new String[n];
        int cur = 0;
        for(int i = 0; i < n; i++) {
            cur = positions.get(i);
            char[] line = new char[n];
            for(int j = 0; j < n; j++) {
                if(j == cur) {
                    line[j] = 'Q';
                } else {
                    line[j] = '.';
                }
            }
            output[i] = new String(line);
        }
        return output;
    }
}
