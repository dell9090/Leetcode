package com.company;
import java.util.*;

class ConvexHall {
    class Point {
        int x;
        int y;
        Point() { x = 0; y = 0; }
        Point(int a, int b) { x = a; y = b; }
    }

    public List<Point> outerTrees(Point[] points) {
        // use a set to make result points non-duplicate
        Set<Point> res = new HashSet<>();
        int leftMost = getLeftMostXIndex(points);
        int cur = leftMost;
        do {
            // get the next point on convex hull in a counterclockwise diretion
            int next = 0;
            for (int i = 0; i < points.length; i++) {
                int orient = orientation(points[cur], points[i], points[next]);
                if (orient < 0 || (orient == 0 && inBetween(points[cur], points[next], points[i]))) next = i;
            }
            // add all collinear points in
            for (int i = 0; i < points.length; i++) {
                if (i != cur && i != next && orientation(points[cur], points[i], points[next]) == 0) {
                    res.add(points[i]);
                }
            }
            // add next and update cur
            res.add(points[next]);
            cur = next;
        } while (cur != leftMost);
        return new ArrayList<Point>(res);
    }
    
    private int getLeftMostXIndex(Point[] points) {
        int leftMost = 0;
        for (int i = 0; i < points.length; i++) {
            if (points[i].x < points[leftMost].x) leftMost = i;
        }
        return leftMost;
    }
    
    private int orientation(Point p, Point q, Point r) {
        return Integer.signum((q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y)); // cross product
    }
    
    private boolean inBetween(Point p, Point i, Point q) {
        return (i.x >= p.x && i.x <= q.x || i.x <= p.x && i.x >= q.x) && // xInBetween
               (i.y >= p.y && i.y <= q.y || i.y <= p.y && i.y >= q.y);   // yInBetween
    }
}