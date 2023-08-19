package src.study.leetcode.uniquePaths;

import java.util.*;

public class Solution {
    class Point{
        int x;
        int y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    int[][] countMap;

    public int uniquePaths(int m, int n) {
        countMap = new int[m][n];

        Queue<Point> pointQueue = new LinkedList<>();
        pointQueue.add(new Point(0, 0));
        countMap[0][0] = 1;
        while(pointQueue.isEmpty() == false){
            Point currentPoint = pointQueue.poll();
            if(currentPoint.x + 1 < m){
                int nextX = currentPoint.x + 1;
                int nextY = currentPoint.y;
                if(countMap[nextX][nextY] == 0){
                    pointQueue.add(new Point(nextX, nextY));
                }
                countMap[nextX][nextY] += countMap[currentPoint.x][currentPoint.y];
            }

            if(currentPoint.y + 1 < n){
                int nextX = currentPoint.x;
                int nextY = currentPoint.y + 1;
                if(countMap[nextX][nextY] == 0){
                    pointQueue.add(new Point(nextX, nextY));
                }
                countMap[nextX][nextY] += countMap[currentPoint.x][currentPoint.y];
            }
        }
        return countMap[m-1][n-1];
    }
}
