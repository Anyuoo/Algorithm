package com.anyu.myhashmap;

public class Test {
    public static void main(String[] args) {
        MyHashMap<Integer, String> myHashMap = new MyHashMap<>(2);
        myHashMap.put(1, "SJDF");
        myHashMap.put(2, "sdfksjdk");
        myHashMap.put(3, "sdfksjdk");
        myHashMap.put(4, "sdfksjdk");
        myHashMap.put(5, "sdfksjdk");
        myHashMap.put(6, "sdfksjdk");

        System.out.println(myHashMap.get(6));
        System.out.println(myHashMap.get(5));
        System.out.println(myHashMap.get(4));
        System.out.println(myHashMap.get(3));
        System.out.println(myHashMap.get(2));
//        System.out.println(myHashMap.get(null));
        System.out.println(myHashMap.get(1));
        System.out.println(myHashMap.size());
    }

}
