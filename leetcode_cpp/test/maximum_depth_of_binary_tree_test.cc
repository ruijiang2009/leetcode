/*
 * maximum_depth_of_binary_tree_test.cc
 *
 *  Created on: Nov 8, 2014
 *      Author: ruijiang
 */

#include "maximum_depth_of_binary_tree.h"
#include "gtest/gtest.h"

TEST(MaximumDepthOfBinaryTree, One) {
    Solution obj;
    TreeNode *root = new TreeNode(2);
    int expected = 1;
    int actual = obj.maxDepth(root);
    EXPECT_EQ(expected, actual);
}
