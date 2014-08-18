package com.programapprentice.app;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created with IntelliJ IDEA.
 * User: ruijiang
 * Date: 8/17/14
 * Time: 10:12 AM
 */

public class BinaryTreeMaximumPathSum {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class MaxSum {
        int max = Integer.MIN_VALUE;
        int singleMax = Integer.MIN_VALUE; // only one chile included
        int globalMax = Integer.MIN_VALUE;
    }

    public int maxPathSum(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return root.val;
        }
        MaxSum maxSum = maxPathSumTree(root);
        return maxSum.globalMax;
    }

    public MaxSum maxPathSumTree(TreeNode root) {
        MaxSum leftMax = new MaxSum();
        MaxSum rightMax = new MaxSum();
        MaxSum output = new MaxSum();

        if(root.left == null && root.right == null) {
            output.max = root.val;
            output.singleMax = root.val;
            output.globalMax = root.val;
            return output;
        }
        if(root.left != null) {
            leftMax = maxPathSumTree(root.left);
        }
        if(root.right != null) {
            rightMax = maxPathSumTree(root.right);
        }

        if (leftMax.singleMax <= 0) {
            if (rightMax.singleMax <= 0) {
                output.max = root.val;
                output.singleMax = root.val;
            } else {
                output.max = root.val + rightMax.singleMax;
                output.singleMax = root.val + rightMax.singleMax;
            }
        } else {
            if (rightMax.singleMax <= 0) {
                output.max = root.val + leftMax.singleMax;
                output.singleMax = root.val + leftMax.singleMax;
            } else {
                output.max = root.val + rightMax.singleMax + leftMax.singleMax;
                output.singleMax = (leftMax.singleMax > rightMax.singleMax ? leftMax.singleMax : rightMax.singleMax) + root.val;
            }
        }

        output.globalMax = output.max > output.singleMax ? output.max : output.singleMax;
        output.globalMax = output.max > leftMax.globalMax ? output.max : leftMax.globalMax;
        output.globalMax = output.globalMax > rightMax.globalMax ? output.globalMax : rightMax.globalMax;

        return output;
    }
}
