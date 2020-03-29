package com.anyu.test;

import java.util.Arrays;

public class CreateTargetArray {
    public int[] createTargetArray(int[] nums, int[] index) {
        int[] res = new int[index.length];
        Arrays.fill(res, Integer.MAX_VALUE);
        int cur = 0;
        for (int idx : index) {
            if (res[idx] == Integer.MAX_VALUE)
                res[idx] = nums[cur++];
            else {
                int tem = res[idx];
                res[idx] = nums[cur++];
                for (int i = idx + 1; res[i] != Integer.MAX_VALUE && i < index.length; i++) {
                    int tem1 = res[i];
                    res[i] = tem;
                    tem = tem1;
                }
                res[idx + 1] = tem;
            }
        }
        return res;
    }
}
