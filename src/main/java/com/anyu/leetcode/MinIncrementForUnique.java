package com.anyu.leetcode;

import java.util.Arrays;

public class MinIncrementForUnique {
    public static int minIncrementForUnique(int[] A) {
        if (A == null || A.length < 2)
            return 0;
        Arrays.sort(A);
        int max = 0;
        int amount = 0;
        int step = 1;
        for (int cur = 1; cur < A.length; cur++) {
            if (A[cur] == A[cur - 1]) {
                amount++;
            } else {
                int diff = A[cur] - A[cur - 1];
                step = 1;
                int d = diff;
                while (d > 1 && amount != 0) {
                    max += step;
                    amount--;
                    step++;
                    d--;
                }
                max += amount * diff;
            }
        }
        step = 1;
        while (amount != 0) {
            max += step;
            amount--;
            step++;
        }
        return max;
    }

    public static void main(String[] args) {
//        System.out.println(minIncrementForUnique(new int[]{3,2,1,2,1,7}));
//        System.out.println(minIncrementForUnique(new int[]{3,2,1,1,1,7}));
//        System.out.println(minIncrementForUnique(new int[]{3,2,1,2,1,7}));
//        System.out.println(minIncrementForUnique(new int[]{3,2,1}));
//        System.out.println(minIncrementForUnique(new int[]{3,2,2}));
//        System.out.println(minIncrementForUnique(new int[]{1,1,1,1}));
        System.out.println(minIncrementForUnique(new int[]{7, 2, 7, 2, 1, 4, 3, 1, 4, 8}));
    }

}
