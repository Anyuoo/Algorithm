package com.anyu.leetcode;

/**
 * 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 * <p>
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int len = nums.length;
        int max = nums[0];
        int res = nums[0];
        for (int i = 1; i < len; i++) {
            max = Math.max(max, 0) + nums[i];
            res = Math.max(res, max);
        }
        return res;
/*        int res=nums[0];
        int sum =0;
        for(int i=0;i<len;i++){
            if (sum>0){
                sum+=nums[i];
            }else {
                sum=nums[i];
            }
            res=Math.max(res,sum);
        }
        return res;*/
    }

}
