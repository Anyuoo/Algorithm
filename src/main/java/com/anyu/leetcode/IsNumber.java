package com.anyu.leetcode;

/**
 * 傻屌题
 * 面试题20. 表示数值的字符串
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"0123"及"-1E-16"都表示数值，
 * 但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
 */

public class IsNumber {
    public static boolean isNumber(String s) {
        if (s == null || s.length() < 1)
            return false;
        int len = s.length();
        if (s.charAt(len - 1) == 'e')
            return false;
        if (len > 1 && s.charAt(0) == '0' && s.charAt(1) == '0')
            return false;
        char[] chars = s.toCharArray();
        final int FIRST = 1;
        final int SECOND = 2;
        final int THIRD = 3;
        final int FORTH = 4;
        int STATE = FIRST;
        int num = 0;
        for (char ch : chars) {
            if (ch == ' ') {
                num++;
                continue;
            }
            switch (STATE) {
                case FIRST:
                    if (Character.isDigit(ch) || ch == '-' || ch == '+' || ch == '.')
                        STATE = SECOND;
                    else
                        return false;
                    break;
                case SECOND:
                    if (ch == '.')
                        STATE = THIRD;
                    else if (Character.isDigit(ch))
                        STATE = SECOND;
                    else if (Character.toLowerCase(ch) == 'e')
                        STATE = FORTH;
                    else
                        return false;
                    break;
                case THIRD:
                    if (Character.isDigit(ch))
                        STATE = THIRD;
                    else
                        return false;
                    break;
                case FORTH:
                    if (Character.isDigit(ch) || ch == '-' || ch == '+')
                        STATE = THIRD;
                    else
                        return false;
                    break;
            }
        }
        return num != len;
    }

    public static void main(String[] args) {
        System.out.println(isNumber("1 "));
        System.out.println(isNumber("0.1"));
        System.out.println(isNumber("0e9"));
        System.out.println(isNumber("-0.1"));
        System.out.println(isNumber("+0123"));
        System.out.println(isNumber("+0123"));
        System.out.println(isNumber("-1E-16"));
        System.out.println(isNumber("+12e"));
        System.out.println(isNumber(" 0"));
    }
}
