package src.study.leetcode.searchInRotatedSortedArray;

import java.util.Arrays;

class Solution {
    public int search(int[] nums, int target) {
        int reversedIndex = findReverseIndex(nums, 0, nums.length - 1);
        System.out.println(reversedIndex);
        if(reversedIndex == -1){
            int searchResult = Arrays.binarySearch(nums, target);
            return searchResult < 0 ? -1 : searchResult;
        } else {
            int leftResult = search(nums, 0, reversedIndex-1, target);
            int rightResult = search(nums, reversedIndex, nums.length - 1, target);
            if(leftResult < 0 && rightResult < 0){
                return -1;
            }
            return leftResult < 0 ? rightResult : leftResult;
        }
    }

    private int search(int[] nums, int min, int max, int target){
        if(min == max){
            return nums[min] == target ? min : -1;
        }

        if(min < max){
            int mid = (min + max) / 2;
            if(nums[mid] == target){
                return mid;
            } else {
                if(target > nums[mid]){
                    return search(nums, mid+1, max, target);
                } else {
                    return search(nums, min, mid - 1, target);
                }
            }
        }
        return -1;
    }

    private int findReverseIndex(int[] nums, int min, int max){
        if(max == min){
            return -1;
        }

        if(nums[min] < nums[max]){
            return -1;
        }

        int mid = (min + max) / 2;
        int leftResult = findReverseIndex(nums, min, mid);
        int rightResult = findReverseIndex(nums, mid+1, max);
        if(leftResult == -1 && rightResult == -1){
            return mid + 1;
        }
        return leftResult != -1 ? leftResult : rightResult;
    }
}

