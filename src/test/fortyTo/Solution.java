package src.test.fortyTo;

public class Solution {
    public class solveResult{
        int height;
        int width;
        long size;

        public solveResult(int height, int width) {
            this.height = height;
            this.width = width;
            this.size = (long) height * width;
        }
    }

    public long solution(int[] height, int[] width) {
        long[] widthSum = new long[width.length];
        int[] shortHeight = new int[height.length];
        long sum = 0;
        int shortTemp = Integer.MAX_VALUE;
        for(int i=0 ; i<width.length ; i++){
            sum += width[i];
            widthSum[i] = sum;

            shortTemp = Math.min(shortTemp, height[i]);
            shortHeight[i]= shortTemp;
        }

        solveResult result = solve(0, height.length - 1, height, width, widthSum, shortHeight);
        return result.size;
    }

    public solveResult solve(int left, int right, int[] height, int[] width, long[] widthSum, int[] shortHeight){
        if(left == right) {
            return new solveResult(height[left], width[left]);
        }
        int mid = (left + right) / 2;
        solveResult leftResult = solve(left, mid, height, width, widthSum, shortHeight);
        solveResult rightResult = solve(mid + 1, right, height, width, widthSum, shortHeight);
        solveResult result;
        if(leftResult.size > rightResult.size){
            result = new solveResult(leftResult.height, leftResult.width);
        } else if(leftResult.size < rightResult.size){
            result = new solveResult(rightResult.height, rightResult.width);
        } else {
            if(leftResult.height > rightResult.height){
                result = new solveResult(leftResult.height, leftResult.width);
            } else if(leftResult.height < rightResult.height){
                result = new solveResult(rightResult.height, rightResult.width);
            } else {
                result = new solveResult(leftResult.height, leftResult.width * 2);
            }
        }
        solveResult sumResult = new solveResult(Math.min(leftResult.height, rightResult.height), leftResult.width + rightResult.width);
        if(sumResult.size > result.size) {
            result = sumResult;
        }
        return result;
    }
}
