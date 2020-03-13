package com.anyu.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * LRU缓存机制
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * <p>
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * <p>
 * 进阶:
 * <p>
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 */
class LRUCache {
    private int size;
    private Map<Integer, Integer> map;
    private Queue<Integer> queue;

    public LRUCache(int capacity) {
        this.map = new HashMap<>(capacity);
        this.queue = new ArrayBlockingQueue<>(capacity);
        this.size = capacity;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(10 /* 缓存容量 */);

        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(11, 2);
        cache.put(3, 2);
        cache.put(4, 2);
        cache.put(5, 2);
        cache.put(6, 2);
        cache.put(7, 2);
        cache.put(8, 2);
        cache.put(9, 2);
        cache.put(10, 2);


        System.out.println(cache.get(1));
        // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        System.out.println(cache.get(2));
        // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        System.out.println(cache.get(1));
        // 返回 -1 (未找到)
        System.out.println(cache.get(3));
        // 返回  3
    }

    public int get(int key) {
//        offer队列满了返回false
        if (!map.containsKey(key)) {
            return -1;
        }
        if (!queue.offer(key)) {
            queue.remove();
            queue.offer(key);
        }
        return map.get(key);
    }

    public void put(int key, int value) {
        if (!queue.offer(key)) {
            if (size == 0 && !map.containsKey(key)) {
                map.remove(queue.poll());
                size++;
            } else {
                queue.remove();
            }
            queue.offer(key);
        }
        if (map.containsKey(key)) {
            map.replace(key, value);
        } else {
            map.put(key, value);
            size--;
        }
    }
}
