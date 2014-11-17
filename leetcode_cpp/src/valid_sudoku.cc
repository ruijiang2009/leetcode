/*
 * valid_sudoku.cc
 *
 *  Created on: Nov 16, 2014
 *      Author: ruijiang
 */

#include "valid_sudoku.h"

bool isValidSudoku(vector<vector<char> > &board) {
    int cur = 0;
    // check each row
    for(int i = 0; i < 9; i++) {
        vector<bool> check(9, false);
        for(int j = 0; j < 9; j++) {
            if(board[i][j] == '.') {
                continue;
            }
            cur = board[i][j] - '1';
            if(check[cur]) {
                return false;
            }
            check[cur] = true;
        }
    }

    // check each col
    for(int i = 0; i < 9; i++) {
        vector<bool> check(9, false);
        for(int j = 0; j < 9; j++) {
            if(board[j][i] == '.') {
                continue;
            }
            cur = board[j][i] - '1';
            if(check[cur]) {
                return false;
            }
            check[cur] = true;
        }
    }

    // check each 9 cells
    for(int i = 0; i < 9; i++) {
        vector<bool> check(9, false);
        int col = (i % 3) * 3;
        int row = (i / 3) * 3;
        for(int j = 0; j < 3; j++) {
            for(int k = 0; k < 3; k++) {
                if(board[j + row][k + col] == '.') {
                    continue;
                }
                cur = board[j + row][k + col] - '1';
                if(check[cur]) {
                    return false;
                }
                check[cur] = true;
            }
        }

    }

    return true;
}
