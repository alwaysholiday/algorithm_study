package src.study.leetcode.combinationSum;

import java.util.*;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new LinkedList<>();
        addPossibleList(result, candidates, target, new LinkedList<>(), 0, 0);
        return result;
    }

    private void addPossibleList(List<List<Integer>> result, int[] candidates, int target, List<Integer> baseBucket, int currentSum, int beforeIndex){
        for(int i=beforeIndex ; i<candidates.length; i++){
            int currentNum = candidates[i];
            int possibleNextNum = currentSum + currentNum;

            if(possibleNextNum == target){
                baseBucket.add(currentNum);
                result.add(new ArrayList(baseBucket));
                baseBucket.remove(baseBucket.size() - 1);
                break;
            }

            if(possibleNextNum > target){
                break;
            }

            baseBucket.add(currentNum);
            addPossibleList(result, candidates, target, baseBucket, currentSum + currentNum, i);
            baseBucket.remove(baseBucket.size() - 1);
        }
    }
}
