package com.programapprentice.app;

/**
 * @author rjiang
 * @date 8/28/14
 */
public class ValidateBinarySearchTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isValidBST(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) {
            return true;
        }
        return isLeftBST(root.left, root.val) && isRightBST(root.right, root.val);
    }

    public boolean isLeftBST(TreeNode root, int max) {
        if(root == null) {
            return true;
        }
        if(null == root.left && null == root.right) {
            if(root.val < max) {
                return true;
            } else {
                return false;
            }
        }
        if(root.val >= max) {
            return false;
        }
        return isLeftBST(root.left, root.val) && isValidBST(root.right, root.val, max);
    }

    public boolean isRightBST(TreeNode root, int min) {
        if(root == null) {
            return true;
        }
        if(null == root.left && null == root.right) {
            if(root.val > min) {
                return true;
            } else {
                return false;
            }
        }
        if(root.val <= min) {
            return false;
        }
        return isValidBST(root.left, min, root.val) && isRightBST(root.right, root.val);
    }
    public boolean isValidBST(TreeNode root, int min, int max) {
        if(root == null) {
            return true;
        }
        if(null == root.left && null == root.right) {
            if(root.val > min && root.val < max) {
                return true;
            } else {
                return false;
            }
        }
        if(root.val <= min || root.val >= max) {
            return false;
        }
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }

}
