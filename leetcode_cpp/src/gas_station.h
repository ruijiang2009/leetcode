/*
 * gas_station.h
 *
 *  Created on: Dec 22, 2014
 *      Author: ruijiang
 */

#ifndef GAS_STATION_H_
#define GAS_STATION_H_

/**
There are N gas stations along a circular route, where the amount of gas at
station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to
travel from station i to its next station (i+1).
You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the
circuit once, otherwise return -1.

Note:
The solution is guaranteed to be unique.
*/

#include <vector>

using namespace::std;

class Solution {
public:
    int canCompleteCircuit(vector<int> &gas, vector<int> &cost);
};
#endif /* GAS_STATION_H_ */
