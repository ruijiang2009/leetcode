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

    private class Result {
        TreeNode first = null;
        TreeNode second = null;

        public Result(TreeNode first, TreeNode second) {
            this.first = first;
            this.second = second;
        }
    }

    // recursive method to do it
    public void recoverTreeRecursive(TreeNode root) {
        TreeNode first = null;
        TreeNode second = null;
        Result result = new Result(first, second);
        recoverTree(root, null, result);
        if(result.first != null && result.second != null) {
            // swap first and second
            int tmp = result.first.val;
            result.first.val = result.second.val;
            result.second.val = tmp;
        }
    }

    public TreeNode recoverTree(TreeNode root, TreeNode pre, Result result) {
        if(root == null) {
            return pre;
        }
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
        return pre;
    }

    public void recoverTree(TreeNode root) {
        if(root == null) {
            return;
        }
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        Stack<String> statusStack = new Stack<String>();
        TreeNode first = null;
        TreeNode second = null;
        TreeNode pre = null;

        nodeStack.push(root);
        statusStack.push("left");
        String topStatus = null;
        TreeNode topNode = null;
        while(!nodeStack.isEmpty()) {
            topStatus = statusStack.pop();
            topNode = nodeStack.peek();
            if(topStatus.equals("left")) {
                if(topNode.left == null) {
                    statusStack.push("root");
                } else {
                    statusStack.push("root");
                    nodeStack.push(topNode.left);
                    statusStack.push("left");
                }
            } else if (topStatus.equals("root")) {
                if(pre != null && pre.val > topNode.val) {
                    if(first == null) {
                        first = pre;
                        second = topNode;
                    } else {
                        second = topNode;
                    }
                }
                pre = topNode;
                nodeStack.pop();
                if(topNode.right != null) {
                    nodeStack.push(topNode.right);
                    statusStack.push("left");
                }
            }
        }

        if(first != null && second != null) {
            // swap first and second
            int tmp = first.val;
            first.val = second.val;
            second.val = tmp;
        }
    }

}
