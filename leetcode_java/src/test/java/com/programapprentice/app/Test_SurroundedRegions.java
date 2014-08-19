package com.programapprentice.app;

import org.junit.Test;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ruijiang
 * Date: 8/18/14
 * Time: 7:03 PM
 */
public class Test_SurroundedRegions {
    SurroundedRegions obj = new SurroundedRegions();
    public void print(char[][] input) {
        int height = input.length;
        int width = input[0].length;
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                System.out.print(input[i][j] + " ");
            }
            System.out.println("");
        }
    }

    @Test
    public void test1() {
        char[][] input = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        obj.solve(input);
        print(input);
    }

    @Test
    public void test2() {
        char[][] input = {{'X', 'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X', 'X'}, {'X', 'X', 'O', 'O', 'X'}, {'X', 'X', 'X', 'X', 'X'}};
        obj.solve(input);
        print(input);
    }

    @Test
    public void test3() {
        char[][] input = {{'X', 'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X', 'X'}, {'O', 'O', 'O', 'O', 'X'}, {'X', 'O', 'X', 'X', 'X'}};
        obj.solve(input);
        print(input);
    }

    @Test
    public void test7() {
        char[][] input = {};
        obj.solve(input);
    }

    @Test
    public void test8() {
        char[][] input = {{}};
        obj.solve(input);
    }
}
