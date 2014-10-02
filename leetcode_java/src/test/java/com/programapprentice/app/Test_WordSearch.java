package com.programapprentice.app;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: ruijiang
 * Date: 9/28/14
 * Time: 3:01 PM
 */
public class Test_WordSearch {
    WordSearch obj = new WordSearch();

    @Test
    public void test1() {
        char[][] board = {{'A', 'B', 'C', 'E',}, {'S', 'F', 'C', 'S',}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        boolean expected = true;
        boolean actual = obj.exist(board, word);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        char[][] board = {{'A', 'B', 'C', 'E',}, {'S', 'F', 'C', 'S',}, {'A', 'D', 'E', 'E'}};
        String word = "SEE";
        boolean expected = true;
        boolean actual = obj.exist(board, word);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        char[][] board = {{'A', 'B', 'C', 'E',}, {'S', 'F', 'C', 'S',}, {'A', 'D', 'E', 'E'}};
        String word = "ABCB";
        boolean expected = false;
        boolean actual = obj.exist(board, word);
        assertEquals(expected, actual);
    }

    @Test
    public void test4() {
        char[][] board = {{'a'}};
        String word = "a";
        boolean expected = true;
        boolean actual = obj.exist(board, word);
        assertEquals(expected, actual);
    }
}
