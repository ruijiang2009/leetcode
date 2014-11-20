/*
 * symmetric_tree.h
 *
 *  Created on: Nov 19, 2014
 *      Author: ruijiang
 */

#ifndef SYMMETRIC_TREE_H_
#define SYMMETRIC_TREE_H_

#define NULL 0

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    bool isSymmetric(TreeNode *root);
    bool isSymmetric(TreeNode *p, TreeNode *q);
};

#endif /* SYMMETRIC_TREE_H_ */
