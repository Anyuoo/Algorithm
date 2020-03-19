package com.anyu.leetcode;

/**
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        if (s == null || s.length() < 1)
            return 0;
        int[] char_table = new int[58];
        int max_len = 0;
        for (int i = 0; i < s.length(); i++)
            char_table[s.charAt(i) - 'A']++;
        for (int num : char_table)
            max_len += num - (num & 1);
        return max_len < s.length() ? max_len + 1 : max_len;
    }

    public static void main(String[] args) {
        System.out.println(3 >> 1);
        System.out.println(0 << 1);
    }
}
