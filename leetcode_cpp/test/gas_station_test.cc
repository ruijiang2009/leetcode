/*
 * gas_station_test.cc
 *
 *  Created on: Dec 22, 2014
 *      Author: ruijiang
 */

#include "gas_station.h"
#include "gtest/gtest.h"

TEST(GasStation, One) {
    Solution obj;
    vector<int> gas;
    gas.push_back(1);
    gas.push_back(2);
    vector<int> cost;
    cost.push_back(2);
    cost.push_back(1);
    int expected = 1;
    int actual = obj.canCompleteCircuit(gas, cost);
    EXPECT_EQ(expected, actual);
}

TEST(GasStation, Two) {
    Solution obj;
    vector<int> gas;
    gas.push_back(5);
    vector<int> cost;
    cost.push_back(4);
    int expected = 0;
    int actual = obj.canCompleteCircuit(gas, cost);
    EXPECT_EQ(expected, actual);
}
