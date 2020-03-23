package com.anyu.leetcode.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 */

public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return null;
        List<List<Integer>> lists = new ArrayList<>();
        LinkedList lbq = new LinkedList();
        lbq.add(root);
        while (!lbq.isEmpty()) {
            int size = lbq.size();
            List<Integer> list = new ArrayList<>(size);
            while (size != 0) {
                TreeNode node = (TreeNode) lbq.poll();
                list.add(node.val);
                if (node.left != null)
                    lbq.add(node.left);
                if (node.right != null)
                    lbq.add(node.right);
                size--;
            }
            lists.add(list);
        }
        return lists;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
