package com.anyu.leetcode;

import java.util.ArrayList;
import java.util.List;

public class GcdOfStrings {
    public String gcdOfStrings(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return "";
        }
        String max_str = str1.length() > str2.length() ? str1 : str2;
        String min_str = str1.length() <= str2.length() ? str1 : str2;
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < min_str.length(); i++) {
            list.add(str1.charAt(i));
        }
        int i = 0;
        while (i < max_str.length() && list.get(i % min_str.length()) == max_str.charAt(i)) {
            i++;
        }

        return "";
    }
}
