package src.study.leetcode.permutationsTwo;

import java.util.*;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Map<Integer, Integer> numsCount = new HashMap<>();
        for(int i=0 ; i<nums.length ; i++){
            if(numsCount.containsKey(nums[i])){
                Integer numCount = numsCount.get(nums[i]);
                numsCount.put(nums[i], numCount+1);
            } else {
                numsCount.put(nums[i], 1);
            }
        }

        List<List<Integer>> result = new LinkedList<>();
        writeResult(result, nums, numsCount, new ArrayList<Integer>(), nums.length);
        return result;
    }

    private void writeResult(List<List<Integer>> result, int[] nums, Map<Integer, Integer> numsCount, List<Integer> baseList, int depth){
        if(depth == 0){
            result.add(new ArrayList(baseList));
            return;
        }

        for(Integer num : numsCount.keySet()){
            Integer currentCount = numsCount.get(num);
            if(currentCount == 0){
                continue;
            }

            baseList.add(num);
            numsCount.put(num, currentCount - 1);
            writeResult(result, nums, numsCount, baseList, depth-1);
            numsCount.put(num, currentCount);
            baseList.remove(baseList.size() - 1);
        }
    }
}
