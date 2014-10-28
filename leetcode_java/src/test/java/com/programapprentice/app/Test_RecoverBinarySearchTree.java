package com.programapprentice.app;

import org.junit.Test;

/**
 * @author rjiang
 * @date 10/28/14
 */
public class Test_RecoverBinarySearchTree {
    RecoverBinarySearchTree obj = new RecoverBinarySearchTree();

    @Test
    public void test1() {
        // {1, 0}
        // Expected: {0,1}
        RecoverBinarySearchTree.TreeNode root = new RecoverBinarySearchTree.TreeNode(0);
        root.left = new RecoverBinarySearchTree.TreeNode(1);
        obj.recoverTree(root);
    }

    @Test
    public void test2() {
        RecoverBinarySearchTree.TreeNode root = new RecoverBinarySearchTree.TreeNode(2);
        root.right = new RecoverBinarySearchTree.TreeNode(1);
        obj.recoverTree(root);
    }

    @Test
    public void test3() {
        // {2, 3, 1}
        RecoverBinarySearchTree.TreeNode root = new RecoverBinarySearchTree.TreeNode(2);
        root.left = new RecoverBinarySearchTree.TreeNode(3);
        root.right = new RecoverBinarySearchTree.TreeNode(1);
        obj.recoverTree(root);
    }

    @Test
    public void test4() {
        // {3,#,1,2}
        // Expected: {1,#,3,2}
        RecoverBinarySearchTree.TreeNode root = new RecoverBinarySearchTree.TreeNode(3);
        root.right = new RecoverBinarySearchTree.TreeNode(2);
        root.right.left = new RecoverBinarySearchTree.TreeNode(1);
        obj.recoverTree(root);
    }

    @Test
    public void test5() {
        // {2, #, 3, 1}
        // Expected: {1, #, 3, 2}
        RecoverBinarySearchTree.TreeNode root = new RecoverBinarySearchTree.TreeNode(2);
        root.right = new RecoverBinarySearchTree.TreeNode(3);
        root.right.left = new RecoverBinarySearchTree.TreeNode(1);
        obj.recoverTree(root);
    }

    @Test
    public void test6() {
        // {2, 1, #, #, 3}
        // Expected: {3,1,#,#,2}
        RecoverBinarySearchTree.TreeNode root = new RecoverBinarySearchTree.TreeNode(2);
        root.left = new RecoverBinarySearchTree.TreeNode(1);
        root.left.right = new RecoverBinarySearchTree.TreeNode(3);
        obj.recoverTree(root);
    }

    /**
     *Input:	{68,41,#,-85,#,-73,-49,-98,#,#,#,-124}
     Output:	{68,-85,#,41,#,-73,-49,-98,#,#,#,-124}
     Expected:	{68,41,#,-73,#,-85,-49,-98,#,#,#,-124}
     */
    @Test
    public void test7() {
        // {68,41,#,-85,#,-73,-49,-98,#,#,#,-124}
        // Expected: {68,41,#,-73,#,-85,-49,-98,#,#,#,-124}
        RecoverBinarySearchTree.TreeNode root = new RecoverBinarySearchTree.TreeNode(2);
        root.left = new RecoverBinarySearchTree.TreeNode(1);
        root.left.right = new RecoverBinarySearchTree.TreeNode(3);
        obj.recoverTree(root);
    }
}
