package src.study.leetcode.uniquePathsTwo;

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

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int heightMax = obstacleGrid.length;
        int widthMax = obstacleGrid[0].length;
        int[][] countMap = new int[heightMax][widthMax];
        Queue<Point> pointQueue = new LinkedList<>();

        if(obstacleGrid[0][0] == 0){
            pointQueue.add(new Point(0,0));
            countMap[0][0] = 1;
        }

        while(pointQueue.isEmpty() == false){
            Point currentPoint = pointQueue.poll();
            addPoint(currentPoint, new Point(currentPoint.x + 1, currentPoint.y), obstacleGrid, pointQueue, countMap, heightMax, widthMax);
            addPoint(currentPoint, new Point(currentPoint.x, currentPoint.y + 1), obstacleGrid, pointQueue, countMap, heightMax, widthMax);
        }
        return countMap[heightMax-1][widthMax-1];
    }

    private void addPoint(Point currentPoint, Point nextPoint, int[][] obstacleInfo, Queue<Point> pointQueue, int[][] countMap, int heightMax, int widthMax){
        int nextX = nextPoint.x;
        int nextY = nextPoint.y;
        if(nextX >= heightMax || nextY >= widthMax){
            return;
        }
        if(obstacleInfo[nextX][nextY] == 1){
            return;
        }

        if(countMap[nextX][nextY] == 0){
            pointQueue.add(nextPoint);
        }
        countMap[nextX][nextY] += countMap[currentPoint.x][currentPoint.y];
    }
}
