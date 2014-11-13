/*
 * binary_tree_level_order_traversal.h
 *
 *  Created on: Nov 9, 2014
 *      Author: ruijiang
 */

#ifndef BINARY_TREE_LEVEL_ORDER_TRAVERSAL_H_
#define BINARY_TREE_LEVEL_ORDER_TRAVERSAL_H_

#include <vector>

using namespace::std;

//#define NULL 0
/**
Given a binary tree, return the level order traversal of its nodes' values.
(ie, from left to right, level by level).
For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
*/

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x): val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    vector<vector<int> > levelOrder(TreeNode *root);
};

#endif /* BINARY_TREE_LEVEL_ORDER_TRAVERSAL_H_ */
