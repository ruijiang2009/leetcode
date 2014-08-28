package com.programapprentice.app;

import java.util.Arrays;

/**
 * @author rjiang
 * @date 8/28/14
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        if(preorder.length == 1 && inorder.length == 1) {
            return root;
        }
        int i = 0;
        for(; i < inorder.length; i++) {
            if(inorder[i] == preorder[0])
                break;
        }
        if(i-1 >= 0) {
            root.left = buildTree(Arrays.copyOfRange(preorder, 1, i + 1), Arrays.copyOfRange(inorder, 0, i));
        } else {
            root.left = null;
        }
        if(i+1 < preorder.length) {
            root.right = buildTree(Arrays.copyOfRange(preorder, i + 1, preorder.length), Arrays.copyOfRange(inorder, i + 1, inorder.length));
        } else {
            root.right = null;
        }
        return root;
    }
}
