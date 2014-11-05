#include <iostream>
#include <map>
#include "two_sum.h"

vector<int> Solution::twoSum(vector<int> &numbers, int target) {
    vector<int> result;
    map<int, int> goal_map;
    map<int,int>::iterator map_it = goal_map.begin();
    for(vector<int>::iterator it = numbers.begin(); it != numbers.end(); ++it) {
        //unordered_map.insert(target - *it, target - *it);
        goal_map.insert(map_it, pair<int,int>(target - *it, target - *it));
    }

    for(vector<int>::iterator it = numbers.begin(); it != numbers.end(); ++it) {
        if(goal_map.end() != goal_map.find(*it)) {
            result.push_back(*it);
            result.push_back(target - *it);
        }
    }

    return result;
}
