package com.programapprentice.app;

import java.util.Hashtable;

/**
 * @author rjiang
 * @date 7/21/14
 */

/* Given n points on a 2D plane, find the maximum number of points that lie on
 the same straight line.
*/

public class MaxPointsOnALine {
    static class Point {
        int x;
        int y;
        Point() { x = 0; y = 0; }
        Point(int a, int b) { x = a; y = b; }
    }

    /** the line equation is  (x - x2)/(x2 - x1) = (y - y1)/(y2/y1)
     * y = [(y2-y1)/(x2-x1)] * x + y1 - [(y2-y1)/(x2-x1)]*x1 */
    static class Line {
        Integer a = 0;
        Integer b = 0;
        Integer x = 0;
        Boolean vertical = false;
        Boolean same = false;

        Line(Integer x, Integer y) { a = x; b = y;}

        Line(boolean value, int x) { vertical = value; this.x = x; }

        Line(boolean value) {same = value;}
        public boolean equals(Object o) {
            if (o == null) return false;
            if (!(o instanceof Line)) return false;
            Line other = (Line)o;
            return this.a==other.a && this.b == other.b && this.vertical == other.vertical && this.x == this.x;
        }

        public int hashCode () {
            return Integer.toString(a.hashCode() + b.hashCode() + vertical.hashCode() + x.hashCode()).hashCode();
        }
    }

    public static int slope(Point a, Point b) {
        return 100000 * (b.y-a.y) / (b.x - a.x);
    }

    public static int intersection(Point a, Point b) {
        return 1000 * a.y - 1000 * (b.y-a.y) / (b.x - a.x) * 1000 * a.x;
    }

    /** the idea is to maintain a n*n matrix to hold line, then maintain a hashtable about line,
     * to calculate how many points on this line*/

    /*This one failed to consider when multiple points are the same point. */
    public static int maxPointsFailed(Point[] points) {
        if (null == points) {
            return 0;
        }
        if (points.length <= 2) {
            return points.length;
        }
        Line[][] lineRecords = new Line[points.length][points.length];
        for(int i = 0; i < points.length; i++) {
            for(int j = i + 1; j < points.length; j++) {
                if(0 == points[i].x - points[j].x) {
                    if(points[i].y == points[j].y) {
                        lineRecords[i][j] = new Line(true);
                    } else {
                        lineRecords[i][j] = new Line(true, points[i].x);
                    }
                } else {
                    lineRecords[i][j] = new Line(slope(points[i], points[j]), intersection(points[i], points[j]));
                }
                lineRecords[j][i] = lineRecords[i][j];
            }
        }

        int max = 0;
        for(int i = 0; i < points.length; i++) {
            Hashtable<Line, Integer> hashtable = new Hashtable<Line, Integer>();
            int sameCount = 0;
            int lineMax = 0;
            for(int j = 0; j < points.length; j++) {
                if(i != j) {
                    if(lineRecords[i][j].same) {
                        sameCount++;
                    } else if (null == hashtable.get(lineRecords[i][j])) {
                        lineMax = lineMax > 1 ? lineMax : 1;
                        hashtable.put(lineRecords[i][j], 1);
                    } else {
                        int tmp = hashtable.get(lineRecords[i][j]);
                        tmp += 1;
                        lineMax = lineMax > tmp ? lineMax : tmp;
                        hashtable.put(lineRecords[i][j], tmp);
                    }
                }
            }
            lineMax += sameCount;
            max = max > lineMax ? max : lineMax;
        }
        return max + 1;
    }

    public static int maxPoints(Point[] points) {
        if (null == points) {
            return 0;
        }
        if (points.length <= 2) {
            return points.length;
        }
        int max = 0;
        for(int i = 0; i < points.length; i++) {
            Hashtable<Integer, Integer> slopeHash = new Hashtable<Integer, Integer>();
            int dup = 0;
            int pointMax = 0;
            int k = 0;
            System.out.println("i is " + i);
            for(int j = 0; j < points.length; j++) {
                if(i != j) {
                    if(points[i].x == points[j].x) {
                        if(points[i].y == points[j].y) {
                            dup++;
                        } else {
                            k = Integer.MAX_VALUE;
                            Integer counter = slopeHash.get(k);
                            if(null == counter) {
                                pointMax = pointMax > 1 ? pointMax : 1;
                                slopeHash.put(k, 1);
                            } else {
                                counter += 1;
                                pointMax = pointMax > counter ? pointMax : counter;
                                slopeHash.put(k, counter);
                            }
                        }
                    } else {
                        k = slope(points[i], points[j]);
                        System.out.println("slope is " + k);
                        Integer counter = slopeHash.get(k);
                        if (null == counter) {
                            pointMax = pointMax > 1 ? pointMax : 1;
                            slopeHash.put(k, 1);
                        } else {
                            counter += 1;
                            pointMax = pointMax > counter ? pointMax : counter;
                            slopeHash.put(k, counter);
                        }
                    }
                }
            }
            max = max > (dup + pointMax) ? max : dup + pointMax;
            System.out.println("dup + pointMax " + (dup + pointMax));
        }

        return max + 1;
    }
}
