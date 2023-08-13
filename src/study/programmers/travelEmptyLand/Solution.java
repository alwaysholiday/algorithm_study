package src.study.programmers.travelEmptyLand;

import java.util.*;

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
    boolean[][] touch;
    int height;
    int weight;
    public int[] solution(String[] maps) {
        map = parseMap(maps);
        touch = new boolean[height][weight];
        List<Integer> landSizeList = new ArrayList<>();
        for(int i=0 ; i<height ; i++){
            for(int j=0 ; j<weight; j++){
                if(touch[i][j] == false){
                    touch[i][j]= true;
                    if(map[i][j] != -1){
                        landSizeList.add(findLand(i, j));
                    }
                }
            }
        }

        if(landSizeList.size() == 0){
            landSizeList.add(-1);
        }
        int[] landSizeArr = landSizeList.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(landSizeArr);
        return landSizeArr;
    }

    private int[][] parseMap(String[] maps){
        height = maps.length;
        weight = maps[0].length();
        int[][] tempMap = new int[height][weight];
        for(int i=0 ; i<maps.length ; i++){
            String mapLine = maps[i];
            for(int j=0 ; j<mapLine.length(); j++){
                char item = mapLine.charAt(j);
                if(item == 'X'){
                    tempMap[i][j] = -1;
                } else {
                    tempMap[i][j] = Character.getNumericValue(item);
                }
            }
        }
        return tempMap;
    }

    private int findLand(int x, int y){
        Queue<Point> pointQueue = new LinkedList<>();
        pointQueue.add(new Point(x, y));
        int landSize = 0;
        while(pointQueue.isEmpty() == false){
            Point currentPoint = pointQueue.poll();
            landSize += map[currentPoint.x][currentPoint.y];
            //up
            int up = checkLand(currentPoint.x-1, currentPoint.y);
            if(up != -1){
                pointQueue.add(new Point(currentPoint.x-1, currentPoint.y));
            }
            //down
            int down = checkLand(currentPoint.x+1, currentPoint.y);
            if(down != -1){
                pointQueue.add(new Point(currentPoint.x+1, currentPoint.y));
            }
            //left
            int left = checkLand(currentPoint.x, currentPoint.y-1);
            if(left != -1){
                pointQueue.add(new Point(currentPoint.x, currentPoint.y-1));
            }
            //right
            int right = checkLand(currentPoint.x, currentPoint.y+1);
            if(right != -1){
                pointQueue.add(new Point(currentPoint.x, currentPoint.y+1));
            }
        }
        return landSize;
    }

    private int checkLand(int x, int y){
        if(x >= height || x < 0){
            return -1;
        }
        if(y >= weight || y < 0){
            return -1;
        }
        if(touch[x][y]){
            return -1;
        }
        touch[x][y] = true;
        return map[x][y] != -1 ? map[x][y] : -1;
    }
}
