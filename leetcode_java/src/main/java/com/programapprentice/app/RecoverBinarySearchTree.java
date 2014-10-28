package com.programapprentice.app;

/**
 * @author rjiang
 * @date 8/28/14
 */

import java.util.Stack;

/**
 * Two elements of a binary search tree (BST) are swapped by mistake.
 *
 * Recover the tree without changing its structure.
 *
 * Note:
 * A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
 * confused what "{1,#,2,3}" means?
 * */
public class RecoverBinarySearchTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


//    public void recoverTree(TreeNode root) {
//        TreeNode first = null;
//        TreeNode second = null;
//        Stack<TreeNode> stack = new Stack<TreeNode>();
//        Stack<String> statusStack = new Stack<String>();
//
//        stack.push(root);
//        statusStack.push("left");
//        TreeNode top = null;
//        String topStatus = null;
//        while(!stack.isEmpty()) {
//            top = stack.peek();
//            topStatus = statusStack.peek();
//            if(topStatus.equals("left")) {
//                topStatus.
//            }
//        }
//
//        // swap first and second
//    }

    private class Result {
        TreeNode first = null;
        TreeNode second = null;

        public Result(TreeNode first, TreeNode second) {
            this.first = first;
            this.second = second;
        }
    }

    public void recoverTree(TreeNode root) {
        TreeNode first = null;
        TreeNode second = null;
        Result result = new Result(first, second);
        recoverTree(root, null, result);
        if(result.first != null && result.second != null) {
            // wap first and second
            int tmp = result.first.val;
            result.first.val = result.second.val;
            result.second.val = tmp;
        }
    }

    public TreeNode recoverTree(TreeNode root, TreeNode pre, Result result) {
        if(root == null) {
            return pre;
        }
        if(pre != null && root.left != null && pre.val > root.left.val) {
            if(result.first == null) {
                result.first = pre;
                result.second = root.left;
            } else {
                result.second = root.left;
            }
        }
        pre = root.left == null ? pre : root.left;
        pre = recoverTree(root.left, pre, result);
        if(pre != null && pre.val > root.val) {
            if(result.first == null) {
                result.first = pre;
                result.second = root;
            } else {
                result.second = root;
            }
        }
        pre = root;
        pre = recoverTree(root.right, pre, result);
        pre = root.right == null ? pre : root.right;
        return pre;
    }

}
