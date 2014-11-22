/*
 * same_tree.h
 *
 *  Created on: Nov 19, 2014
 *      Author: ruijiang
 */

#ifndef SAME_TREE_H_
#define SAME_TREE_H_

#define NULL 0

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    bool isSameTree(TreeNode *p, TreeNode *q);
};



#endif /* SAME_TREE_H_ */
