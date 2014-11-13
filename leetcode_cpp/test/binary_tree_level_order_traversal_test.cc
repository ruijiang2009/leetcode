/*
 * binary_tree_level_order_traversal_test.cc
 *
 *  Created on: Nov 9, 2014
 *      Author: ruijiang
 */

#include "binary_tree_level_order_traversal.h"
#include "gtest/gtest.h"

void printVector(vector<vector<int> > result) {
    for(int i = 0; i < result.size(); i++) {
        vector<int> list = result[i];
        for(int j = 0; j < list.size(); j++) {
            cout << list[j] << '\t';
        }
        cout << endl;
    }
}
/**
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \
        7    2
 */

TEST(BinaryTreeLevelOrderTraversal, One) {
    Solution obj;
    TreeNode *root = new TreeNode(5);
    root->left = new TreeNode(4);
    root->left->left = new TreeNode(11);
    root->left->left->left = new TreeNode(7);
    root->left->left->right = new TreeNode(2);
    root->right = new TreeNode(8);
    root->right->left = new TreeNode(13);
    root->right->right = new TreeNode(4);
    vector<vector<int> > result = obj.levelOrder(root);
    printVector(result);
}
