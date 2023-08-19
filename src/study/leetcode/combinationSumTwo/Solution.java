package src.study.leetcode.combinationSumTwo;

import java.util.*;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new LinkedList<>();
        addPossibleList(result, candidates, target, new ArrayList<>(), 0, 0);
        return result;
    }

    private void addPossibleList(List<List<Integer>> result, int[] candidates, int target, List<Integer> basicBucket, int currentSum, int startIndex){
        Set<Integer> filterSet = new HashSet<>();
        for(int i = startIndex ; i<candidates.length ; i++){
            int currentNum = candidates[i];
            if(filterSet.contains(currentNum)){
                continue;
            }
            filterSet.add(currentNum);
            int nextPossibleNum = currentSum + currentNum;
            if(nextPossibleNum == target){
                basicBucket.add(currentNum);
                result.add(new ArrayList<>(basicBucket));
                basicBucket.remove(basicBucket.size() - 1);
                break;
            }
            if(nextPossibleNum > target){
                break;
            }
            basicBucket.add(currentNum);
            addPossibleList(result, candidates, target, basicBucket, nextPossibleNum, i + 1);
            basicBucket.remove(basicBucket.size() - 1);
        }
    }
}
