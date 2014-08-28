package com.programapprentice.app;

import org.junit.Test;

/**
 * @author rjiang
 * @date 8/28/14
 */
public class Test_ConstructBinaryTreeFromPreorderAndInorderTraversal {
    ConstructBinaryTreeFromPreorderAndInorderTraversal obj = new ConstructBinaryTreeFromPreorderAndInorderTraversal();

    @Test
    public void test1() {
        int[] preorder = {1, 2};
        int[] inorder = {2, 1};
        ConstructBinaryTreeFromPreorderAndInorderTraversal.TreeNode tree = obj.buildTree(preorder, inorder);
    }

    @Test
    public void test2() {
        int[] preorder = {1, 2};
        int[] inorder = {1, 2};
        ConstructBinaryTreeFromPreorderAndInorderTraversal.TreeNode tree = obj.buildTree(preorder, inorder);
    }

    @Test
    public void test3() {
        int[] preorder = {1, 2, 3};
        int[] inorder = {3, 2, 1};
        ConstructBinaryTreeFromPreorderAndInorderTraversal.TreeNode tree = obj.buildTree(preorder, inorder);
    }
}
