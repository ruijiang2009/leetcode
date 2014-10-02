package com.programapprentice.app;

/**
 * Created with IntelliJ IDEA.
 * User: ruijiang
 * Date: 9/28/14
 * Time: 2:37 PM
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 * For example,
 * Given board =
 *
 * [
 * ["ABCE"],
 * ["SFCS"],
 * ["ADEE"]
 * ]
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 * */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if(board == null ||word == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        int height = board.length;
        int width = board[0].length;
        boolean[][] visited = new boolean[height][width];
        for(int i = 0; i < height; i ++) {
            for (int j = 0; j < width; j++) {
                if(board[i][j] == word.charAt(0)) {
                    visited[i][j] = true;
                    if(exist(board, height, width, i, j, word, 0, visited)) {
                        return true;
                    }
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }

    // DFS search
    public boolean exist(char[][] board, int height, int width,
                         int row, int col, String word, int index,
                         boolean[][] visited) {
        if(index == word.length() - 1) {
            return true;
        }
        char nextChar = word.charAt(index + 1);
        int newIndex = index + 1;
        int newRow , newCol;

        // up
        newRow = row - 1;
        newCol = col;
        if(newRow >= 0 && !visited[newRow][newCol] && board[newRow][newCol] == nextChar) {
            if(newIndex == word.length() - 1) {
                return true;
            }
            visited[newRow][newCol] = true;
            if(exist(board, height, width, newRow, newCol, word, newIndex,visited)) {
                return true;
            }
            visited[newRow][newCol] = false;
        }
        // down
        newRow = row + 1;
        newCol = col;
        if(newRow < height && !visited[newRow][newCol] && board[newRow][newCol] == nextChar) {
            if(newIndex == word.length() - 1) {
                return true;
            }
            visited[newRow][newCol] = true;
            if(exist(board, height, width, newRow, newCol, word, newIndex,visited)) {
                return true;
            }
            visited[newRow][newCol] = false;
        }
        // left
        newRow = row;
        newCol = col - 1;
        if(newCol >= 0 && !visited[newRow][newCol] && board[newRow][newCol] == nextChar) {
            if(newIndex == word.length() - 1) {
                return true;
            }
            visited[newRow][newCol] = true;
            if(exist(board, height, width, newRow, newCol, word, newIndex,visited)) {
                return true;
            }
            visited[newRow][newCol] = false;
        }
        // right
        newRow = row;
        newCol = col + 1;
        if(newCol < width && !visited[newRow][newCol] && board[newRow][newCol] == nextChar) {
            if(newIndex == word.length() - 1) {
                return true;
            }
            visited[newRow][newCol] = true;
            if(exist(board, height, width, newRow, newCol, word, newIndex,visited)) {
                return true;
            }
            visited[newRow][newCol] = false;
        }
        return false;
    }

}
