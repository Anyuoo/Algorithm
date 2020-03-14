package com.anyu.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);
        for (int pointer = 0; pointer < len - 2; pointer++) {
            if (nums[pointer] > 0)
                break;
            if (pointer == 0 || nums[pointer] != nums[pointer - 1]) {
                int left = pointer + 1;
                int right = len - 1;
                while (left < right) {
                    int sum = nums[pointer] + nums[right] + nums[left];
                    if (sum < 0) {
                        while (left < right && nums[left] == nums[++left]) ;
                    } else if (sum > 0) {
                        while (left < right && nums[right] == nums[--right]) ;
                    } else {
                        res.add(Arrays.asList(nums[pointer], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[++left]) ;
                        while (left < right && nums[right] == nums[--right]) ;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        threeSum(new int[]{1, -1, -1, 0});
    }
}
