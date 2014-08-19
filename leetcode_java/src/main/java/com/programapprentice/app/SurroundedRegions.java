package com.programapprentice.app;

/**
 * Created with IntelliJ IDEA.
 * User: ruijiang
 * Date: 8/18/14
 * Time: 7:03 PM
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 * For example,
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 *
 * After running your function, the board should be:
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X*/
public class SurroundedRegions {
    class Point {
        int x = 0;
        int y = 0;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public void solve(char[][] board) {
        if(board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return;
        }
        Queue<Point> queue = new LinkedList<Point>();
        List<Point> points = new ArrayList<Point>();

        int height = board.length;
        int width = board[0].length;
        boolean[][] scanStatus = new boolean[height][width];
        Point cur = null;
        boolean isSurrounded = true;
        int w, h = 0;
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                if(board[i][j] == 'X') {
                    scanStatus[i][j] = true;
                } else {
                    if(!scanStatus[i][j]) {
                        queue.add(new Point(i, j));
                        scanStatus[i][j] = true;
                        while(!queue.isEmpty()) {
                            cur = queue.remove();
                            points.add(cur);
                            // up
                            h = cur.x-1;
                            w = cur.y;
                            if(h >= 0) {
                                if(board[h][w] == 'O' && !scanStatus[h][w]) {
                                    queue.add(new Point(h, w));
                                    scanStatus[h][w] = true;
                                }
                            } else {
                                isSurrounded = false;
                            }
                            // left
                            h = cur.x;
                            w = cur.y -1;
                            if(w >= 0) {
                                if(board[h][w] == 'O' && !scanStatus[h][w]) {
                                    queue.add(new Point(h, w));
                                    scanStatus[h][w] = true;
                                }
                            } else {
                                isSurrounded = false;
                            }
                            // right
                            h = cur.x;
                            w = cur.y + 1;
                            if(w < width) {
                                if(board[h][w] == 'O' && !scanStatus[h][w]) {
                                    queue.add(new Point(h, w));
                                    scanStatus[h][w] = true;
                                }
                            } else {
                                isSurrounded = false;
                            }
                            // down
                            h = cur.x + 1;
                            w = cur.y;
                            if(h < height) {
                                if(board[h][w] == 'O' && !scanStatus[h][w]) {
                                    queue.add(new Point(h, w));
                                    scanStatus[h][w] = true;
                                }
                            } else {
                                isSurrounded = false;
                            }

                        }
                        if(isSurrounded) {
                            for(Point point : points) {
                                board[point.x][point.y] = 'X';
                            }
                        }
                        queue = new LinkedList<Point>();
                        points = new ArrayList<Point>();
                        isSurrounded = true;
                    }
                }
            }
        }
    }
}
