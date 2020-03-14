package com.anyu.myhashmap;

import java.lang.reflect.Array;

/**
 * 实现JDK1.8前的 数组加链表的HashMap
 *
 * @param <K>
 * @param <V>
 */
public class MyHashMap<K, V> {

    private int capacity;//容量
    private final int DEAFAULT_CAPACITY = 1 << 4;//初始化为16
    private int size = 0;//数据数量
    private Entry[] list;

    public MyHashMap() {
        //        创建数组存储，因为Entry是泛型类所以要通过Array类的newinstance创建实例
        this.list = (Entry[]) Array.newInstance(Entry.class, DEAFAULT_CAPACITY);
    }

    public MyHashMap(int capacity) {
        this.capacity = capacity;
//        创建数组存储，因为Entry是泛型类所以要通过Array类的newinstance创建实例
        this.list = (Entry[]) Array.newInstance(Entry.class, capacity);
    }

    /**
     * put
     *
     * @param key
     * @param value
     */
    public void put(K key, V value) {
        //哈希算法的数组地址

        if (key == null) {
            return;
        }
        int index = hash(key);
        Entry new_entry = null;
        if (list[index] == null)
            new_entry = new Entry(key, value, key.hashCode(), null);
        else
            //头插法
            new_entry = new Entry(key, value, key.hashCode(), list[index]);
        size++;
        list[index] = new_entry;
    }

    /**
     * @param key
     * @return value
     */
    public V get(K key) {
        int index = hash(key);
        if (list[index] == null) {
            return null;
        } else {
            while (list[index] != null) {
                if (key == list[index].getKey() && key.hashCode() == list[index].getHash()) {
                    return list[index].getValue();
                }
                list[index] = list[index].next();
            }
            return null;
        }
    }

    public int size() {
        return size;
    }

    /**
     * 哈希算法获取数组地址
     *
     * @param key
     * @return
     */
    private int hash(K key) {
        return Math.abs(key == null ? 0 : key.hashCode() % (capacity != 0 ? capacity : DEAFAULT_CAPACITY) - 1);
    }

    /**
     * 存放键值对实体
     */
    private class Entry {
        private K key;
        private V value;
        private int hash;
        private Entry next;

        public Entry() {
        }

        public Entry(K key, V value, int hash, Entry next) {
            this.key = key;
            this.value = value;
            this.hash = hash;
            this.next = next;
        }

        public boolean hasNext() {
            return this.next != null;
        }

        public Entry next() {
            return this.next;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public Integer getHash() {
            return hash;
        }

        public void setHash(Integer hash) {
            this.hash = hash;
        }

        public Entry getNext() {
            return next;
        }

        public void setNext(Entry next) {
            this.next = next;
        }
    }
}
