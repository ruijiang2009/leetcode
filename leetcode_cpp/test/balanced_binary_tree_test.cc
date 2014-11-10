/*
 * balanced_binary_tree_test.cc
 *
 *  Created on: Nov 8, 2014
 *      Author: ruijiang
 */

#include "balanced_binary_tree.h"
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

TEST(BalancedBinaryTree, One) {
    Solution obj;
    TreeNode *root = new TreeNode(5);
    root->left = new TreeNode(4);
    root->left->left = new TreeNode(11);
    root->left->left->left = new TreeNode(7);
    root->left->left->right = new TreeNode(2);
    root->right = new TreeNode(8);
    root->right->left = new TreeNode(13);
    root->right->right = new TreeNode(4);
    bool expected = false;
    bool actual = obj.isBalanced(root);
    EXPECT_EQ(expected, actual);
}


// {1, 2}
TEST(BalancedBinaryTree, Two) {
    Solution obj;
    TreeNode *root = new TreeNode(1);
    root->left = new TreeNode(2);
    bool expected = true;
    bool actual = obj.isBalanced(root);
    EXPECT_EQ(expected, actual);
}

TEST(BalancedBinaryTree, Three) {
    Solution obj;
    TreeNode *root = new TreeNode(1);
    bool expected = true;
    bool actual = obj.isBalanced(root);
    EXPECT_EQ(expected, actual);
}

TEST(BalancedBinaryTree, Four) {
    Solution obj;
    TreeNode *root = new TreeNode(1);
    root->right = new TreeNode(2);
    root->right->right = new TreeNode(3);
    bool expected = false;
    bool actual = obj.isBalanced(root);
    EXPECT_EQ(expected, actual);
}


