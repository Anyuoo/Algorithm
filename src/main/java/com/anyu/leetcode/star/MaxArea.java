package com.anyu.leetcode.star;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 */
public class MaxArea {
    public int maxArea(int[] height) {
        int res = 0;
        int right = height.length - 1;
        int left = 0;
        while (left < right) {
            while (left < right && height[left] == 0) {
                left++;
            }
            while (left < right && height[right] == 0) {
                right--;
            }
            if (left < right) {
                if (height[left] > height[right]) {
                    res = Math.max((right - left) * height[right], res);
                    right--;
                } else {
                    res = Math.max((right - left) * height[left], res);
                    left++;
                }
//               int hgt = height[left] > height[right] ? height[right--] : height[left++];
//               res = (right - left + 1) * hgt > res ? (right - left + 1) * hgt : res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MaxArea maxArea = new MaxArea();
        System.out.println(maxArea.maxArea(new int[]{0, 14, 6, 2, 10, 9, 4, 1, 10, 3}));
        System.out.println(maxArea.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(maxArea.maxArea(new int[]{}));
    }
}
