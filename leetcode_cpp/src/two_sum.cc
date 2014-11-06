#include <iostream>
#include <map>
#include "two_sum.h"

vector<int> Solution::twoSum(vector<int> &numbers, int target) {
    vector<int> result;
    map<int, int> goal_map;
    for(int i = 0; i < numbers.size(); i++) {
        goal_map[numbers[i]] = i;
    }
    int tmp_target = 0;
    for(int i = 0; i < numbers.size(); i++) {
        tmp_target = target - numbers[i];
        if(goal_map.find(tmp_target) != goal_map.end()) {
            if(goal_map[tmp_target] != i) {
                result.push_back(i+1);
                result.push_back(goal_map[tmp_target] + 1);
                break;
            }
        }
    }

    return result;
}
