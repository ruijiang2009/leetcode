/*
 * binary_tree_level_order_traversal.cc
 *
 *  Created on: Nov 9, 2014
 *      Author: ruijiang
 */

#include "binary_tree_level_order_traversal.h"
#include <queue>

vector<vector<int> > Solution::levelOrder(TreeNode * root) {
    queue<TreeNode*> oddQueue;
    queue<TreeNode*> evenQueue;
    vector<vector<int> > result;
    if(NULL == root) {
        return result;
    }
    oddQueue.push(root);
    bool isOddRow = true;
    TreeNode* tmp;
    vector<int> list;
    while(!oddQueue.empty() || !evenQueue.empty()) {
        if(isOddRow) {
            tmp = oddQueue.front();
            oddQueue.pop();
            list.push_back(tmp->val);
            if(tmp->left != NULL) {
                evenQueue.push(tmp->left);
            }
            if(tmp->right != NULL) {
                evenQueue.push(tmp->right);
            }
            if(oddQueue.empty()) {
                isOddRow = false;
                result.push_back(list);
                list.clear();
            }
        } else {
            tmp = evenQueue.front();
            evenQueue.pop();
            list.push_back(tmp->val);
            if(tmp->left != NULL) {
                oddQueue.push(tmp->left);
            }
            if(tmp->right != NULL) {
                oddQueue.push(tmp->right);
            }
            if(evenQueue.empty()) {
                isOddRow = true;
                result.push_back(list);
                list.clear();
            }
        }
    }
    return result;
}


