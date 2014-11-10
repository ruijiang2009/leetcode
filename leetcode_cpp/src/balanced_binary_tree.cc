/*
 * balanced_binary_tree.cc
 *
 *  Created on: Nov 8, 2014
 *      Author: ruijiang
 */

#include "balanced_binary_tree.h"

using namespace::std;

bool Solution::isBalanced(TreeNode *root, int& depth) {
    if(NULL == root) {
        depth = 0;
        return true;
    }
    if(NULL == root->left && NULL == root->right) {
        depth = 1;
        return true;
    }
    int leftDepth = 0;
    int rightDepth = 0;
    bool leftBalance= isBalanced(root->left, leftDepth);
    bool rightBalance = isBalanced(root->right, rightDepth);
    depth = (leftDepth > rightDepth ? leftDepth : rightDepth) + 1;
    if(leftBalance && rightBalance) {
        if(leftDepth - rightDepth > 1 || leftDepth - rightDepth < -1) {
            return false;
        } else {
            return true;
        }
    }
    return false;
}

bool Solution::isBalanced(TreeNode *root) {
    if(NULL == root) {
        return true;
    }
    int depth;
    return isBalanced(root, depth);
}
