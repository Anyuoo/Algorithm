package com.anyu.leetcode.contest;

/**
 * 给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
 * 换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。
 * 以数组形式返回答案
 */
public class SmallerNumbersThanCurrent {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] res = new int[nums.length];
        for (int cur = 0; cur < nums.length; cur++)
            res[cur] = amount(nums, nums[cur]);
        return res;
    }

    public int amount(int[] nums, int exp) {
        int mount = 0;
        for (int num : nums) {
            if (num < exp)
                mount++;
        }
        return mount;
    }
}
