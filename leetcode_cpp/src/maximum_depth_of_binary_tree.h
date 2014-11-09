/*
 * maximum_depth_of_binary_tree.h
 *
 *  Created on: Nov 8, 2014
 *      Author: ruijiang
 */

/*
* Given a binary tree, find its maximum depth.
*
* The maximum depth is the number of nodes along the longest path
* from the root node down to the farthest leaf node.
*/


#ifndef MAXIMUM_DEPTH_OF_BINARY_H
#define MAXIMUM_DEPTH_OF_BINARY_H

#define NULL 0

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x): val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    int maxDepth(TreeNode *root);
};

#endif
