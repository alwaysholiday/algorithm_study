package src.study.leetcode.permutations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        boolean[] touched = new boolean[nums.length];
        List<List<Integer>> result = new LinkedList<>();
        writeList(result, nums, new ArrayList<>(), touched, nums.length);
        return result;
    }

    private void writeList(List<List<Integer>> result, int[] nums, List<Integer> basicList, boolean[] touched, int depth){
        if(depth == 0){
            result.add(new ArrayList<>(basicList));
            return;
        }

        for(int i=0 ; i<nums.length ; i++){
            if(touched[i]){
                continue;
            }
            basicList.add(nums[i]);
            touched[i] = true;
            writeList(result, nums, basicList, touched, depth - 1);
            basicList.remove(basicList.size() - 1);
            touched[i] = false;
        }
    }
}
