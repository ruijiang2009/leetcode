/*
 * path_sum_test.cc
 *
 *  Created on: Nov 8, 2014
 *      Author: ruijiang
 */

#include "path_sum.h"
#include "gtest/gtest.h"

TEST(PathSum, One) {
    Solution obj;
    int sum = 22;
    TreeNode *root = new TreeNode(5);
    root->left = new TreeNode(4);
    root->left->left = new TreeNode(11);
    root->left->left->left = new TreeNode(7);
    root->left->left->right = new TreeNode(2);
    root->right = new TreeNode(8);
    root->right->left = new TreeNode(13);
    root->right->right = new TreeNode(4);
    root->right->right->right = new TreeNode(1);
    bool expected = true;
    bool actual = obj.hasPathSum(root, sum);
    EXPECT_EQ(expected, actual);
}
