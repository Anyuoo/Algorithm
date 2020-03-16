package com.anyu;

/**
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 * 示例 1:
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 */
public class MaxProfit {
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;
        final int BEGIN = 0;
        final int UP = 1;
        final int DOWN = 2;
        int max_profit = 0;
        int high = Integer.MIN_VALUE;
        int low = Integer.MAX_VALUE;
        int STATE = BEGIN;
        int i = 1;
        while (i < prices.length) {
            int price = prices[i] - prices[i - 1];
            switch (STATE) {
                case BEGIN:
                    if (price < 0) {
                        STATE = DOWN;
                        low = prices[i];
                    } else if (price > 0) {
                        STATE = UP;
                        low = prices[i - 1];
                        max_profit = price;
                    } else
                        STATE = BEGIN;
                    break;

                case UP:
                    if (price < 0) {
                        STATE = DOWN;
                        high = prices[i - 1];
                        max_profit = max_profit > (high - low) ? max_profit : high - low;
                        low = low > prices[i - 1] ? prices[i - 1] : low;
                    } else {
                        STATE = UP;
                        high = prices[i] > high ? prices[i] : high;
                        max_profit = max_profit > (high - low) ? max_profit : high - low;
                    }
                    break;

                case DOWN:
                    if (price > 0) {
                        STATE = UP;
                        high = Integer.MIN_VALUE;
                        low = low > prices[i - 1] ? prices[i - 1] : low;
                        high = prices[i] > high ? prices[i] : high;
                        max_profit = max_profit > (high - low) ? max_profit : high - low;
                    } else
                        STATE = DOWN;
                    break;
            }
            i++;
        }
        return max_profit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}) == 5);
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}) == 0);
        System.out.println(maxProfit(new int[]{1, 3, 8}) == 7);
        System.out.println(maxProfit(new int[]{2, 1, 4}) == 3);
        System.out.println(maxProfit(new int[]{2, 1, 2, 0, 1}) == 1);

    }
}
