package src.study.leetcode.jumpGame;

import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public boolean canJump(int[] nums) {
        Queue<Integer> numQueue = new LinkedList<>();
        boolean[] touched = new boolean[nums.length];
        numQueue.add(0);
        touched[0] = true;
        while(numQueue.isEmpty() == false){
            Integer first = numQueue.poll();
            int addValue = nums[first];
            for(int i=1 ; i<=addValue && first+i < nums.length ; i++){
                if(first + i == nums.length - 1){
                    return true;
                }

                if(touched[first+i] == false){
                    touched[first+i] = true;
                    numQueue.add(first+i);
                }
            }
        }
        return touched[nums.length-1];
    }
}