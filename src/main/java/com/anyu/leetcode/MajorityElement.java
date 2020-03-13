package com.anyu.leetcode;

public class MajorityElement {
    public static int majorityElement(int[] nums) {

//        Arrays.sort(nums);
//        int len=nums.length;
//        if(nums[len-1]==nums[len/2]){
//            return nums[len/2];
//        }else {
//            return nums[len/2-1];
//        }
//    }
        int max_data = nums[0];
        int cot = 1;
        for (int i = 1; i < nums.length; i++) {
            if (max_data == nums[i]) {
                cot++;
            } else {
                cot--;
                if (cot == 0) {
                    max_data = nums[i + 1];
                }
            }
        }
        return max_data;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{2, 3, 2}));
    }
}
