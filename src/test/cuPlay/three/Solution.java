package src.test.cuPlay.three;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    int[][] map;
    int height;
    int weight;
    List<Point> zeroList;

    public int solution(String[] maps) {
        parseMap(maps);
        int size = 0;
        for(Point item : zeroList){
            map[item.x][item.y] = 1;
            size = Math.max(size, findBiggestIsland());
            map[item.x][item.y] = 0;
        }
        return size;
    }

    private void parseMap(String[] maps){
        height = maps.length;
        weight = maps[0].length();
        map = new int[height][weight];
        zeroList = new LinkedList<>();
        for(int i=0 ; i < height ; i++){
            String mapLine = maps[i];
            for(int j=0 ; j<weight ; j++){
                int mapsNum = Character.getNumericValue(mapLine.charAt(j));
                map[i][j] = mapsNum;
                if(mapsNum == 0){
                    zeroList.add(new Point(i, j));
                }
            }
        }
    }

    private int findBiggestIsland(){
        boolean[][] touch = new boolean[height][weight];
        int biggestSize = 0;
        for(int i=0 ; i<height ; i++){
            for(int j=0 ; j<weight ; j++){
                if(touch[i][j]){
                    continue;
                }

                touch[i][j] = true;
                if(map[i][j] == 1){
                    int landSize = findLand(i, j, touch);
                    biggestSize = Math.max(biggestSize, landSize);
                }
            }
        }
        return biggestSize;
    }

    private int findLand(int x, int y, boolean[][] touch){
        Queue<Point> pointQueue = new LinkedList<>();
        pointQueue.add(new Point(x, y));
        int landSize = 0;
        while(pointQueue.isEmpty() == false){
            Point currentPoint = pointQueue.poll();
            landSize++;
            //up
            if(checkLand(currentPoint.x-1, currentPoint.y, touch)){
                pointQueue.add(new Point(currentPoint.x-1, currentPoint.y));
            }
            //down
            if(checkLand(currentPoint.x+1, currentPoint.y, touch)){
                pointQueue.add(new Point(currentPoint.x+1, currentPoint.y));
            }
            //left
            if(checkLand(currentPoint.x, currentPoint.y-1, touch)){
                pointQueue.add(new Point(currentPoint.x, currentPoint.y-1));
            }
            //right
            if(checkLand(currentPoint.x, currentPoint.y+1, touch)){
                pointQueue.add(new Point(currentPoint.x, currentPoint.y+1));
            }
        }
        return landSize;
    }

    private boolean checkLand(int x, int y, boolean[][] touch){
        if(x >= height || x < 0){
            return false;
        }
        if(y >= weight || y < 0){
            return false;
        }
        if(touch[x][y]){
            return false;
        }
        touch[x][y] = true;
        return map[x][y] == 1;
    }
}
