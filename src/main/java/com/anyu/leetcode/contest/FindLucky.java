package com.anyu.leetcode.contest;

import java.util.HashMap;
import java.util.Map;

/**
 * 找幸运数字，数字个数等于数字本身
 */
public class FindLucky {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int res = 0;
        for (int num : arr) {
            if (map.containsKey(num)) {
                int val = map.get(num) + 1;
                map.replace(num, val);
            } else
                map.put(num, 1);
        }
        for (int key : map.keySet()) {
            if (map.get(key) == key)
                res = res > key ? res : key;
        }
        return res == 0 ? -1 : res;
    }
}
