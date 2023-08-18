package src.study.leetcode.searchInRotatedSortedArray;

import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        int[] inputs = new int[]{4,5,6,7,0,1,2};
        int target = 2;
        Solution solution = new Solution();
        System.out.println(solution.search(inputs, target));
    }
}
