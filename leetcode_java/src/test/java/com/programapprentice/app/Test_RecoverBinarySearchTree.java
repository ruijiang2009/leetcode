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
        // {2, #, 1}
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

    @Test
    public void test7() {
        // {68,41,#,-85,#,-73,-49,-98,#,#,#,-124}
        // Expected: {68,41,#,-73,#,-85,-49,-98,#,#,#,-124}
        RecoverBinarySearchTree.TreeNode root = new RecoverBinarySearchTree.TreeNode(68);
        root.left = new RecoverBinarySearchTree.TreeNode(41);
        root.left.left = new RecoverBinarySearchTree.TreeNode(-85);
        root.left.left.left = new RecoverBinarySearchTree.TreeNode(-73);
        root.left.left.right = new RecoverBinarySearchTree.TreeNode(-49);
        root.left.left.left.left = new RecoverBinarySearchTree.TreeNode(-98);
        root.left.left.left.left.left = new RecoverBinarySearchTree.TreeNode(-124);
        obj.recoverTree(root);
    }

    @Test
    public void test8() {
        // {3,1,#,#,2,#,4}
        // Expected: {4,1,#,#,2,#,3}
        RecoverBinarySearchTree.TreeNode root = new RecoverBinarySearchTree.TreeNode(3);
        root.left = new RecoverBinarySearchTree.TreeNode(1);
        root.left.right = new RecoverBinarySearchTree.TreeNode(2);
        root.left.right.right = new RecoverBinarySearchTree.TreeNode(4);
        obj.recoverTree(root);
    }
}
