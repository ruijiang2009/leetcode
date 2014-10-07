package com.programapprentice.app;

import org.junit.Test;

import java.util.List;

/**
 * User: ruijiang
 * Date: 10/4/14
 * Time: 10:37 PM
 */
public class Test_NQueens {
    NQueens obj = new NQueens();
    NQueensII obj2 = new NQueensII();

    @Test
    public void test1() {
        List<String[]> output = obj.solveNQueens(4);
        printOutput(output);
    }

    @Test
    public void test2() {
        List<String[]> output = obj.solveNQueens(8);
        int num = obj2.totalNQueens(8);
        System.out.println("# Solution is " + num);
        printOutput(output);
    }

    private void printOutput(List<String[]> output) {
        for(String[] list : output) {
            for(String str : list) {
                System.out.println(str);
            }
            System.out.println();
            System.out.println();
        }
    }
}
