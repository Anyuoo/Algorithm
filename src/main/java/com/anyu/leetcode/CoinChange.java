package com.anyu.leetcode;

import java.util.Arrays;
//给一个总额amount的面值，用硬币coins[]换，至少需要到少个，不满足返回-1
public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length < 1)
            return -1;
        if (amount <= 0)
            return 0;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 10);
        int min_coin = Integer.MAX_VALUE;
        for (int coin : coins) {
            //找到最小的硬币
            min_coin = coin > min_coin ? min_coin : coin;
            if (coin > amount)
                continue;
            dp[coin] = 1;
        }
        if (min_coin > amount) //最小的硬币都大于总额，不满足
            return -1;
        dp[0] = 0;
        for (int i = min_coin; i <= amount; i++)
            for (int coin : coins)
                if (i - coin >= 0)
                    dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
//        System.out.println(coinChange(new int[]{2},3));
        System.out.println(coinChange(new int[]{474, 83, 404, 3
        }, 264));
//        System.out.println(coinChange(new int[]{186,419,83,408},
//        6249));
    }
}
