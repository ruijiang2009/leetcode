package com.programapprentice.app;

import org.junit.Test;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ruijiang
 * Date: 10/25/14
 * Time: 9:19 PM
 */
public class Test_UniqueBinarySearchTreesII {
    UniqueBinarySearchTreeII obj = new UniqueBinarySearchTreeII();

    @Test
    public void test1() {
        int input = 3;
        List<UniqueBinarySearchTreeII.TreeNode> actual = obj.generateTrees(input);
    }
}
