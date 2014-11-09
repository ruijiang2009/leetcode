/*
 * minimum_depth_of_binary_tree.h
 *
 *  Created on: Nov 8, 2014
 *      Author: ruijiang
 */

#ifndef MINIMUM_DEPTH_OF_BINARY_TREE_H_
#define MINIMUM_DEPTH_OF_BINARY_TREE_H_

#define NULL 0

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x): val(x), left(NULL), right(NULL) {}
};

/**
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from
 * the root node down to the nearest leaf node.
 */
class Solution {
public:
    int minDepth(TreeNode *root);
    int minDepth(TreeNode *root, int currentDepth);
};

#endif /* MINIMUM_DEPTH_OF_BINARY_TREE_H_ */
