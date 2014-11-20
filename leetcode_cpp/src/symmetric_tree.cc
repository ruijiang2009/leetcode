/*
 * symmetric_tree.cc
 *
 *  Created on: Nov 19, 2014
 *      Author: ruijiang
 */

#include "symmetric_tree.h"

bool Solution::isSymmetric(TreeNode *p, TreeNode *q) {
    if(p == NULL && q == NULL) {
        return true;
    }
    if(p == NULL || q == NULL) {
        return false;
    }
    if(p->val != q->val) {
        return false;
    }
    bool result1 = isSymmetric(p->left, q->right);
    bool result2 = isSymmetric(p->right, q->left);
    return result1 && result2;
}

bool Solution::isSymmetric(TreeNode *root) {
    if(root == NULL) {
        return true;
    }
    return isSymmetric(root->left, root->right);
}
