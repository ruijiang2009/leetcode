/*
 * same_tree.cc
 *
 *  Created on: Nov 19, 2014
 *      Author: ruijiang
 */

#include "same_tree.h"

bool Solution::isSameTree(TreeNode *p, TreeNode *q) {
    if(NULL == p && NULL == q) {
        return true;
    }
    if(NULL == p || NULL == q) {
        return false;
    }
    bool rootResult = p->val == q->val;
    bool leftResult = isSameTree(p->left, q->left);
    bool rightResult = isSameTree(p->right, q->right);

    return (leftResult && rightResult && rootResult);
}
