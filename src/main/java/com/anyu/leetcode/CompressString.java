package com.anyu.leetcode;

/**
 * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
 * <p>
 * 示例1:
 * <p>
 * 输入："aabcccccaaa"
 * 输出："a2b1c5a3"
 * 示例2:
 * <p>
 * 输入："abbccd"
 * 输出："abbccd"
 * 解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长
 */

public class CompressString {
    public static String compressString(String S) {
        int len = S.length();
        String res = "";
        int ch_size = 1;
        for (int i = 1; i <= len; i++) {
            if (i < len && S.charAt(i - 1) == S.charAt(i)) {
                ch_size++;
            } else {
                res += String.valueOf(S.charAt(i - 1)) + ch_size;
                ch_size = 1;
            }
        }
        return res.length() >= len ? S : res;
    }

    public static void main(String[] args) {
        System.out.println(compressString("rrrrrLLLLLPPPPPPRRRRRgggNNNNNVVVVVVVVVVDDDDDDDDDDIIIIIIIIIIlllllllAAAAqqqqqqqbbbNNNNffffff"));
    }
}
