/*
 * path_sum.cc
 *
 *  Created on: Nov 8, 2014
 *      Author: ruijiang
 */

#include "path_sum.h"

// recursive way to do it
bool Solution::hasPathSum(TreeNode *root, int sum) {
    if(NULL == root) {
        return false;
    }
    if(NULL == root->left and NULL == root->right) {
        return root->val == sum;
    }
    return hasPathSum(root->left, sum - root->val) ||
            hasPathSum(root->right, sum - root->val);
}
