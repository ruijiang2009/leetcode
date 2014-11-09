/*
 * minimum_depth_of_binary_tree.cc
 *
 *  Created on: Nov 8, 2014
 *      Author: ruijiang
 */

#include "minimum_depth_of_binary_tree.h"

int Solution::minDepth(TreeNode *root, int currentDepth) {
    if(NULL == root) {
        return currentDepth;
    }
    int leftDepth = minDepth(root->left, currentDepth + 1);
    int rightDepth = minDepth(root->right, currentDepth + 1);
    if(NULL != root->left && NULL != root->right) {
        return leftDepth > rightDepth ? rightDepth : leftDepth;
    }
    if(NULL == root->left) {
        return rightDepth;
    } else {
        // if(NULL == root->right) {
        return leftDepth;
    }
}

int Solution::minDepth(TreeNode *root) {
    if(NULL == root) {
        return 0;
    }
    return minDepth(root, 0);
}
