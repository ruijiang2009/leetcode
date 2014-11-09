/*
 * maximum_depth_of_binary_tree.cpp
 *
 *  Created on: Nov 8, 2014
 *      Author: ruijiang
 */


#include "maximum_depth_of_binary_tree.h"


int depth(TreeNode *root, int currentDepth) {
    if(NULL == root) {
        return currentDepth;
    }
    int leftDepth = depth(root->left, currentDepth + 1);
    int rightDepth = depth(root->right, currentDepth + 1);
    return leftDepth > rightDepth ? leftDepth : rightDepth;
}

int Solution::maxDepth(TreeNode *root) {
    if(NULL == root) {
        return 0;
    }
    return depth(root, 0);
}

