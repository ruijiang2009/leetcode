/*
 * path_sum.h
 *
 *  Created on: Nov 8, 2014
 *      Author: ruijiang
 */

#ifndef PATH_SUM_H_
#define PATH_SUM_H_

#define NULL 0

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x): val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    bool hasPathSum(TreeNode *root, int sum);
};


#endif /* PATH_SUM_H_ */
