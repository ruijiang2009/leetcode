package com.programapprentice.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ruijiang
 * Date: 10/25/14
 * Time: 7:48 PM
 */
public class UniqueBinarySearchTreeII {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; left = null; right = null; }
    }

    public List<TreeNode> generateTrees(int n) {
        if(0 == n) {
            List<TreeNode> result = new ArrayList<TreeNode>();
            result.add(null);
            return result;
        }
        int[] array = new int[n];
        for(int i = 0; i < n; i++) {
            array[i] = i + 1;
        }
        return generateTrees(array);
    }

    public List<TreeNode> generateTrees(int[] A) {
        if(A == null || A.length == 0) {
            List<TreeNode> result = new ArrayList<TreeNode>();
            result.add(null);
            return result;
        }

        if(A.length == 1) {
            List<TreeNode> output = new ArrayList<TreeNode>();
            output.add(new TreeNode(A[0]));
            return output;
        }
        if(A.length == 2) {
            List<TreeNode> output = new ArrayList<TreeNode>();
            TreeNode node = new TreeNode(A[0]);
            node.right = new TreeNode(A[1]);
            output.add(node);
            node = new TreeNode(A[1]);
            node.left = new TreeNode(A[0]);
            output.add(node);
            return output;
        }

        List<TreeNode> result = new ArrayList<TreeNode>();
        for(int i = 0; i < A.length; i++) {
            TreeNode node;
            List<TreeNode> leftCandidates;
            if(i != 0) {
                leftCandidates = generateTrees(Arrays.copyOfRange(A, 0, i));
            } else {
                leftCandidates = new ArrayList<TreeNode>();
                leftCandidates.add(null);
            }
            List<TreeNode> rightCandidates = generateTrees(Arrays.copyOfRange(A, i+1, A.length));
            for(TreeNode left : leftCandidates) {
                for(TreeNode right : rightCandidates) {
                    node = new TreeNode(A[i]);
                    node.left = left;
                    node.right = right;
                    result.add(node);
                }
            }
        }
        return result;
    }
}
