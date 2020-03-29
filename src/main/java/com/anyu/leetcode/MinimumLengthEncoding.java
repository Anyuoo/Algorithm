package com.anyu.leetcode;

import java.util.Arrays;

/**
 * 单词编码
 */
public class MinimumLengthEncoding {
    public int minimumLengthEncoding(String[] words) {
        int res = 0;
        Trie trie = new Trie();
        // 先对单词列表根据单词长度由长到短排序
        Arrays.sort(words, (s1, s2) -> s2.length() - s1.length());
        // 单词插入trie，返回该单词增加的编码长度
        for (String word : words) {
            res += trie.insert(word);
        }
        return res;
    }

    class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public int insert(String chars) {
            TrieNode curnode = root;
            boolean isNew = false;
            for (int cur = chars.length() - 1; cur >= 0; cur--) {
                int loc = chars.charAt(cur) - 'a';
                if (curnode.nodes[loc] == null) {
                    TrieNode node = new TrieNode();
                    node.val = chars.charAt(cur);
                    curnode.nodes[loc] = node;
                    isNew = true;
                }
                curnode = curnode.nodes[loc];
            }
            return isNew ? chars.length() + 1 : 0;
        }
    }

    class TrieNode {
        char val;
        TrieNode[] nodes;

        public TrieNode() {
            nodes = new TrieNode[26];
        }

        public void setCh(char val) {
            this.val = val;
        }
    }

}
