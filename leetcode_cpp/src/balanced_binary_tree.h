/*
 * balanced_binary_tree.h
 *
 *  Created on: Nov 8, 2014
 *      Author: ruijiang
 */

#ifndef BALANCED_BINARY_TREE_H_
#define BALANCED_BINARY_TREE_H_

#define NULL 0

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x): val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    bool isBalanced(TreeNode *root);
    bool isBalanced(TreeNode *root, int& depth);
};

#endif /* BALANCED_BINARY_TREE_H_ */
