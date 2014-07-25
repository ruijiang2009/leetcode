package com.programapprentice.app;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author rjiang
 * @date 7/22/14
 */
public class Test_MaxPointsOnALine {
    @Test
    public void test1() {
        /*[(84,250),(0,0),(1,0),(0,-70),(0,-70),(1,-1),(21,10),(42,90),(-42,-230)]
        * Expected: 6*/
        MaxPointsOnALine.Point[] points = new MaxPointsOnALine.Point[9];
        points[0] = new MaxPointsOnALine.Point(84, 250);
        points[1] = new MaxPointsOnALine.Point(0, 0);
        points[2] = new MaxPointsOnALine.Point(1, 0);
        points[3] = new MaxPointsOnALine.Point(0, -70);
        points[4] = new MaxPointsOnALine.Point(0, -70);
        points[5] = new MaxPointsOnALine.Point(1, -1);
        points[6] = new MaxPointsOnALine.Point(21, 10);
        points[7] = new MaxPointsOnALine.Point(42, 90);
        points[8] = new MaxPointsOnALine.Point(-42, -230);

        assertEquals(6, MaxPointsOnALine.maxPoints(points));
    }

    @Test
    public void test2() {
        /*[(1,1),(1,1),(2,2),(2,2)]
        * Expected: 4*/
        MaxPointsOnALine.Point[] points = new MaxPointsOnALine.Point[4];
        points[0] = new MaxPointsOnALine.Point(1, 1);
        points[1] = new MaxPointsOnALine.Point(1, 1);
        points[2] = new MaxPointsOnALine.Point(2, 2);
        points[3] = new MaxPointsOnALine.Point(2, 2);

        assertEquals(4, MaxPointsOnALine.maxPoints(points));
    }

    @Test
    public void test3() {
        /* (0,0),(1,1),(1,-1)
        * Expected: 2*/
        MaxPointsOnALine.Point[] points = new MaxPointsOnALine.Point[3];
        points[0] = new MaxPointsOnALine.Point(0, 0);
        points[1] = new MaxPointsOnALine.Point(1, 1);
        points[2] = new MaxPointsOnALine.Point(1, -1);

        assertEquals(2, MaxPointsOnALine.maxPoints(points));
    }

    @Test
    public void test4() {
        String[] input = {"560,248", "0,16", "30,250", "950,187", "630,277", "950,187", "-212,-268", "-287,-222", "53,37", "-280,-100", "-1,-14", "-5,4", "-35,-387", "-95,11", "-70,-13", "-700,-274", "-95,11", "-2,-33", "3,62", "-4,-47", "106,98", "-7,-65", "-8,-71", "-8,-147", "5,5", "-5,-90", "-420,-158", "-420,-158", "-350,-129", "-475,-53", "-4,-47", "-380,-37", "0,-24", "35,299", "-8,-71", "-2,-6", "8,25", "6,13", "-106,-146", "53,37", "-7,-128", "-5,-1", "-318,-390", "-15,-191", "-665,-85", "318,342", "7,138", "-570,-69", "-9,-4", "0,-9", "1,-7", "-51,23", "4,1", "-7,5", "-280,-100", "700,306", "0,-23", "-7,-4", "-246,-184", "350,161", "-424,-512", "35,299", "0,-24", "-140,-42", "-760,-101", "-9,-9", "140,74", "-285,-21", "-350,-129", "-6,9", "-630,-245", "700,306", "1,-17", "0,16", "-70,-13", "1,24", "-328,-260", "-34,26", "7,-5", "-371,-451", "-570,-69", "0,27", "-7,-65", "-9,-166", "-475,-53", "-68,20", "210,103", "700,306", "7,-6", "-3,-52", "-106,-146", "560,248", "10,6", "6,119", "0,2", "-41,6", "7,19", "30,250"};
        MaxPointsOnALine.Point[] points = new MaxPointsOnALine.Point[input.length];
        System.out.println("number of points " + input.length);
        for(int i = 0; i < input.length; i++) {
            String[] cordinations = input[i].split(",");
            points[i] = new MaxPointsOnALine.Point(Integer.parseInt(cordinations[0]), Integer.parseInt(cordinations[1]));
        }

        assertEquals(22, MaxPointsOnALine.maxPoints(points));
    }
}
