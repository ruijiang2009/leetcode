package com.programapprentice.app;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: ruijiang
 * Date: 8/17/14
 * Time: 10:50 AM
 */
public class Test_BinaryTreeMaximumPathSum {
    BinaryTreeMaximumPathSum obj = new BinaryTreeMaximumPathSum();

    @Test
    public void test1() {
        BinaryTreeMaximumPathSum.TreeNode root = new BinaryTreeMaximumPathSum.TreeNode(1);
        root.left = new BinaryTreeMaximumPathSum.TreeNode(2);
        root.right = new BinaryTreeMaximumPathSum.TreeNode(3);
        int output = obj.maxPathSum(root);
        int expected = 6;
        assertEquals(expected, output);
    }


    @Test
    public void test2() {
        BinaryTreeMaximumPathSum.TreeNode root = new BinaryTreeMaximumPathSum.TreeNode(1);
        root.left = new BinaryTreeMaximumPathSum.TreeNode(1);
        root.right = new BinaryTreeMaximumPathSum.TreeNode(1);
        root.left.left = new BinaryTreeMaximumPathSum.TreeNode(5);
        root.left.right = new BinaryTreeMaximumPathSum.TreeNode(6);
        root.left.left.left = new BinaryTreeMaximumPathSum.TreeNode(4);
        root.left.left.right = new BinaryTreeMaximumPathSum.TreeNode(8);

        int output = obj.maxPathSum(root);
        int expected = 20;
        assertEquals(expected, output);
    }

    @Test
    public void test3() {
        BinaryTreeMaximumPathSum.TreeNode root = new BinaryTreeMaximumPathSum.TreeNode(1);
        root.left = new BinaryTreeMaximumPathSum.TreeNode(1);
        root.right = new BinaryTreeMaximumPathSum.TreeNode(1);
        root.left.left = new BinaryTreeMaximumPathSum.TreeNode(5);
        root.left.right = new BinaryTreeMaximumPathSum.TreeNode(1);
        root.left.left.left = new BinaryTreeMaximumPathSum.TreeNode(9);
        root.left.left.right = new BinaryTreeMaximumPathSum.TreeNode(8);

        int output = obj.maxPathSum(root);
        int expected = 22;
        assertEquals(expected, output);
    }

    @Test
    public void test4() {
        BinaryTreeMaximumPathSum.TreeNode root = new BinaryTreeMaximumPathSum.TreeNode(1);
        root.left = new BinaryTreeMaximumPathSum.TreeNode(1);
        root.right = new BinaryTreeMaximumPathSum.TreeNode(1);
        root.left.left = new BinaryTreeMaximumPathSum.TreeNode(5);
        root.left.right = new BinaryTreeMaximumPathSum.TreeNode(1);
        root.left.left.left = new BinaryTreeMaximumPathSum.TreeNode(4);
        root.left.left.left = new BinaryTreeMaximumPathSum.TreeNode(4);
        root.left.left.right = new BinaryTreeMaximumPathSum.TreeNode(8);

        int output = obj.maxPathSum(root);
        int expected = 17;
        assertEquals(expected, output);
    }

    @Test
    public void test5() {
        BinaryTreeMaximumPathSum.TreeNode root = new BinaryTreeMaximumPathSum.TreeNode(2);
        root.right = new BinaryTreeMaximumPathSum.TreeNode(-1);

        int output = obj.maxPathSum(root);
        int expected = 2;
        assertEquals(expected, output);
    }
}
