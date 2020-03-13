package com.anyu.leetcode;

import java.util.Stack;

public class Prictice {
    public boolean stack(int[] nums) {
        if (nums == null || nums.length < 1) {
            return false;
        }
        int n = nums.length;
        Stack<Integer> squ = new Stack<>();
        int cur = 0;
        for (int val = 0; val <= n; val++) {
            if (nums[cur] == val) {
                cur++;
                while (!squ.isEmpty() && nums[cur] == squ.peek()) {
                    cur++;
                    squ.pop();
                }
            } else {
                squ.push(val);
            }
        }
        return squ.isEmpty();
    }
}
