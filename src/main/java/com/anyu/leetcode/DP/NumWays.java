package com.anyu.leetcode.DP;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * 示例 1：
 * 输入：n = 2
 * 输出：2
 * 示例 2：
 * 输入：n = 7
 * 输出：21
 */
public class NumWays {
    public int numWays(int num) {
        if (num == 0)
            return 1;
        if (num == 1)
            return 1;
        if (num == 2)
            return 2;
        int[] dp = new int[num + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 2; i <= num; i++)
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        return dp[num];
    }
}