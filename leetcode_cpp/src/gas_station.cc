/*
 * gas_station.cc
 *
 *  Created on: Dec 22, 2014
 *      Author: ruijiang
 */

#include "gas_station.h"
#include <iostream>

using namespace::std;

int Solution::canCompleteCircuit(vector<int> &gas, vector<int> &cost) {
    int length = gas.size();
    int left = 0;
    int start = 0;
    int end = 0;
    while(start<length) {
        left = 0;
        for(end = 0; end < length; end++) {
            left += gas[(start + end) % length] - cost[(start + end) % length];

            if(left < 0) {
                break;
            }
        }
        cout << "left is " << left << " end is " << end << " start is " << start << endl;
        if(end == length && left >= 0) {
            return start;
        }
        start = start + end + 1;
    }
    return -1;
}
