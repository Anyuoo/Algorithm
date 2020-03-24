package com.anyu.leetcode;

/**
 * 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接.
 * 在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。
 * 给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
 */
public class Massage {
    public int massage(int[] nums) {
        if (nums == null || nums.length < 1)
            return 0;
        if (nums.length == 1)
            return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], nums[0]);
        for (int cur = 2; cur < nums.length; cur++) {
            dp[cur] = Math.max(dp[cur - 1], nums[cur] + dp[cur - 2]);
            if (cur - 3 >= 0)
                dp[cur] = Math.max(dp[cur], dp[cur - 3] + nums[cur]);
        }
        return dp[nums.length - 1];
    }
}
