package com.anyu.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
 * 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
 * 注意：每次拼写时，chars 中的每个字母都只能用一次。
 * 返回词汇表 words 中你掌握的所有单词的 长度之和。
 * 示例 1：
 * 输入：words = ["cat","bt","hat","tree"], chars = "atach"
 * 输出：6
 * 解释：
 * 可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。
 */
public class CountCharacters {
    /**
     * 方法一：用hashmap存放字符及出现次数
     *
     * @param words
     * @param chars
     * @return
     */
    public static int countCharacters(String[] words, String chars) {
        if (words == null || words.length < 1 || chars.length() < 1)
            return 0;
        int max_count = 0;
        Map<Character, Integer> char_table = new HashMap<>();
        Map<Character, Integer> char_tab = new HashMap<>();
        for (int i = 0; i < chars.length(); i++) {
            char ch = chars.charAt(i);
            int count = 1;
            if (char_table.containsKey(ch)) {
                count = char_table.get(ch);
                count++;
            }
            char_table.put(ch, count);
        }
        for (String word : words) {
            char_tab.putAll(char_table);
            int cur = 0;
            int flag = 0;
            for (cur = 0; cur < word.length(); cur++) {
                char ch = word.charAt(cur);
                if (char_table.containsKey(ch) && char_table.get(ch) > 0) {
                    char_table.replace(ch, char_table.get(ch) - 1);
                } else {
                    flag = 1;
                    break;
                }
            }
            char_table.putAll(char_tab);
            if (flag == 0)
                max_count += cur;
        }
        return max_count;
    }

    /**
     * 方法二：将字符串转变为小写字符，在转为字符数组，共有26个字符那么可以创建一个整形数组存储字母出现次数，数组下标为字符-'a'=0~25;
     *
     * @param words
     * @param chars
     * @return
     */
    public static int countCharacters1(String[] words, String chars) {
        if (words == null || words.length < 1 || chars.length() < 1)
            return 0;
        int max_count = 0;
        int[] char_table = new int[26];
        int[] char_tab;
        for (char ch : chars.toLowerCase().toCharArray())
            char_table[ch - 'a']++;
        for (String word : words) {
            char_tab = char_table.clone();
            int flag = 0;
            for (char ch : word.toLowerCase().toCharArray()) {
                if (char_table[ch - 'a'] < 1) {
                    flag = 1;
                    break;
                } else
                    char_table[ch - 'a']--;
            }
            if (flag == 0)
                max_count += word.length();
            char_table = char_tab.clone();
        }
        return max_count;
    }

    public static void main(String[] args) {
        System.out.println(countCharacters1(new String[]{"cat", "bt", "hat", "tree"}, "atach"));
        System.out.println(countCharacters1(new String[]{"hello", "world", "leetcode"}, "welldonehoneyr"));
    }
}
