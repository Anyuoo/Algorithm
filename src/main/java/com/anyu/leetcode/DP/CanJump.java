package com.anyu.leetcode.DP;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个位置。
 * <p>
 * 示例 1:
 * <p>
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * 示例 2:
 * <p>
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 */
public class CanJump {
    //    public boolean canJump(int[] nums) {
//        if (nums == null || nums.length < 2)
//            return true;
//        int[] dp=new int[nums.length];
//        dp[0]=nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            if (dp[i-1] == 0)
//                return false;
//            dp[i]=dp[i-1]-1 > nums[i] ? dp[i-1]-1 :nums[i];
//        }
//        return true;
//    }
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length < 2)
            return true;
        int[] dp = new int[2];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[0] == 0)
                return false;
            dp[1] = dp[0] - 1 > nums[i] ? dp[0] - 1 : nums[i];
            dp[0] = dp[1];
        }
        return true;
    }

    public static void main(String[] args) {
        CanJump canJump = new CanJump();
        System.out.println(canJump.canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(canJump.canJump(new int[]{3, 2, 1, 0, 4}));
        System.out.println(canJump.canJump(new int[]{2, 0, 0}));
    }
}
