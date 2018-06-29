//Given some points and a point origin in two dimensional space, 
//find k points out of the some points which are nearest to origin.
//Return these points sorted by distance, if they are same with distance, sorted by x-axis, otherwise sorted by y-axis.

//Example
//Given points = [[4,6],[4,7],[4,4],[2,5],[1,1]], origin = [0, 0], k = 3
//return [[1,1],[2,5],[4,4]]



/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * } * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

public class Solution {
    
    private Point origin;
    private int size;
    
    /**
     * @param points: a list of points
     * @param origin: a point
     * @param k: An integer
     * @return: the k closest points
     */
    public Point[] kClosest(Point[] points, Point origin, int k) {
        if (points == null || points.length == 0) {
            return points;
        }
        
        this.origin = origin;
        
        // O(n)
        heapify(points);
        
        Point[] results = new Point[k];
        
        // O(klogn)
        for (int i = 0; i < k; i++) {
            results[i] = pop(points);
        }
        
        return results;
    }
    
    private void heapify(Point[] points) {
        size = points.length;
        
        for(int i = size / 2; i >= 0; i--) {
            siftDown(points, i);
        }
    }
    
    private void siftDown(Point[] points, int index) {
        while (index < size) {
            int left = index * 2 + 1;
            int right = index * 2 + 2;
            int min = index;
            
            if (left < size && compare(points[min], points[left]) > 0) {
                min = left;
            }
            if (right < size && compare(points[min], points[right]) > 0) {
                min = right;
            }
            
            if (index != min) {
                Point temp = points[index];
                points[index] = points[min];
                points[min] = temp;
                index = min;
            }
            else {
                break;
            }
        }
    }
    
    private Point pop(Point[] points) {
        Point top = points[0];
        points[0] = points[size - 1];
        this.size--;
        
        siftDown(points, 0);
        return top;
    }
    
    private int compare(Point a, Point b) {
        int square = distance(a, origin) - distance(b, origin);
        if (square != 0) {
            return square;
        }
        
        return a.x != b.x ? a.x - b.x : a.y - b.y;
    }
    
    private int distance(Point a, Point b) {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
    }
}

