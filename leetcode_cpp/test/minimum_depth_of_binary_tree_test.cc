/*
 * minimum_depth_of_binary_tree_test.cc
 *
 *  Created on: Nov 8, 2014
 *      Author: ruijiang
 */

#include "minimum_depth_of_binary_tree.h"
#include "gtest/gtest.h"

/**
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \
        7    2
 */

TEST(MinimumDepthOfBinaryTree, One) {
    Solution obj;
    TreeNode *root = new TreeNode(5);
    root->left = new TreeNode(4);
    root->left->left = new TreeNode(11);
    root->left->left->left = new TreeNode(7);
    root->left->left->right = new TreeNode(2);
    root->right = new TreeNode(8);
    root->right->left = new TreeNode(13);
    root->right->right = new TreeNode(4);
    int expected = 3;
    int actual = obj.minDepth(root);
    EXPECT_EQ(expected, actual);
}


// {1, 2}
TEST(MinimumDepthOfBinaryTree, Two) {
    Solution obj;
    TreeNode *root = new TreeNode(1);
    root->left = new TreeNode(2);
    int expected = 2;
    int actual = obj.minDepth(root);
    EXPECT_EQ(expected, actual);
}

TEST(MinimumDepthOfBinaryTree, Three) {
    Solution obj;
    TreeNode *root = new TreeNode(1);
    int expected = 1;
    int actual = obj.minDepth(root);
    EXPECT_EQ(expected, actual);
}
