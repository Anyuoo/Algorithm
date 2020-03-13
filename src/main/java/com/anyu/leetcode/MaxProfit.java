package com.anyu.leetcode;

public class MaxProfit {
    public static int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int[] max_p = new int[len];
        int min_prince = prices[0];
        int pointer;
        for (pointer = 1; pointer < len; pointer++) {
            if (min_prince > prices[pointer]) {
                min_prince = prices[pointer];
            }
            max_p[pointer] = Math.max(prices[pointer] - min_prince, max_p[pointer - 1]);
        }
        return max_p[pointer - 1];
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1, 2, 3, 4}));
    }
}
