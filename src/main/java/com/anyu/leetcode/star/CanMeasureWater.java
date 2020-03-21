package com.anyu.leetcode.star;

/**
 * 有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
 * 如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。
 * 你允许：
 * 装满任意一个水壶
 * 清空任意一个水壶
 * 从一个水壶向另外一个水壶倒水，直到装满或者倒空
 * 示例 1: (From the famous "Die Hard" example)
 * 输入: x = 3, y = 5, z = 4
 * 输出: True
 * 示例 2:
 * 输入: x = 2, y = 6, z = 5
 * 输出: False
 */
public class CanMeasureWater {
    public boolean canMeasureWater(int x, int y, int z) {
        if (z == 0)
            return true;
        if (x == 0)
            return y == z;
        if (y == 0)
            return x == z;
        if (x + y < z)
            return false;
        return z % (gcd(x, y)) == 0;
    }
    //*

    /**
     * 算最大公因数==公因数乘积
     *
     * @param max
     * @param min
     * @return
     */
    public int gcd(int max, int min) {
        if (max == min)//当两个值相等时，停止运算
            return max;
        if ((max & 1) == 0 && (min & 1) == 0) {//当传入参数都为偶数时，位运算缩小，同时两者有公因数2，因此在进行位运算（辗转相除法）
            return gcd(max >> 1, min >> 1) << 1;
        } else if ((max & 1) == 0 && (min & 1) == 1)
            return gcd(max >> 1, min);
        else if ((max & 1) == 1 && (min & 1) == 0)
            return gcd(max, min >> 1);
        else {
            if (max > min)//当两个参数都为奇数时，用更相减损运算求值
                return gcd(max - min, min);
            else
                return gcd(max, min - max);
        }
    }


    public static void main(String[] args) {
        System.out.println(new CanMeasureWater().canMeasureWater(1, 1, 12));
        System.out.println(new CanMeasureWater().canMeasureWater(0, 0, 1));
        System.out.println(new CanMeasureWater().canMeasureWater(5, 6, 7));
        System.out.println(new CanMeasureWater().canMeasureWater(7, 0, 7));
        System.out.println(new CanMeasureWater().canMeasureWater(0, 6, 6));
        System.out.println(new CanMeasureWater().canMeasureWater(34, 5, 6));
        System.out.println(new CanMeasureWater().canMeasureWater(7, 5, 9));
    }

}
