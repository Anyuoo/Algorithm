package com.anyu.leetcode.contest;

import java.util.HashMap;
import java.util.Map;

/**
 * 请你实现一个类 UndergroundSystem ，它支持以下 3 种方法：
 * 1. checkIn(int id, string stationName, int t)
 * 编号为 id 的乘客在 t 时刻进入地铁站 stationName 。
 * 一个乘客在同一时间只能在一个地铁站进入或者离开。
 * 2. checkOut(int id, string stationName, int t)
 * 编号为 id 的乘客在 t 时刻离开地铁站 stationName 。
 * 3. getAverageTime(string startStation, string endStation) 
 * 返回从地铁站 startStation 到地铁站 endStation 的平均花费时间。
 * 平均时间计算的行程包括当前为止所有从 startStation 直接到达 endStation 的行程。
 * 调用 getAverageTime 时，询问的路线至少包含一趟行程。
 * 你可以假设所有对 checkIn 和 checkOut 的调用都是符合逻辑的。也就是说，如果一个顾客在 t1 时刻到达某个地铁站，那么他离开的时间 t2 一定满足 t2 > t1 。所有的事件都按时间顺序给出。
 */
public class UndergroundSystem {
    Map<Integer, Person> map;
    Map<String, Double> timemap;

    public UndergroundSystem() {
        map = new HashMap<Integer, Person>();
        timemap = new HashMap<String, Double>();
    }

    public void checkIn(int id, String stationName, int t) {
        if (map.containsKey(id)) {
            Person person = map.get(id);
            if (person.getEtime() == 0 || person.getEtime() >= t)
                return;
        }
        Person person = new Person();
        person.setStartStation(stationName);
        person.setStime(t);
        map.put(id, person);
    }

    public void checkOut(int id, String stationName, int t) {
        if (!map.containsKey(id))
            return;
        if (map.containsKey(id)) {
            Person person = map.get(id);
            if (person.getStime() == 0)
                return;
        }
        Person person = map.get(id);
        person.setEndStation(stationName);
        person.setEtime(t);
    }

    public double getAverageTime(String startStation, String endStation) {
        double sumtime = 0.0;
        int times = 0;
        for (int id : map.keySet()) {
            Person person = map.get(id);
            if (person.getStartStation() != null && person.endStation != null && person.getStartStation().equals(startStation) && person.getEndStation().equals(endStation)) {
                sumtime += (person.getEtime() - person.getStime());
                times++;
            }
        }
        return sumtime / times;
    }

    class Person {
        private String startStation;
        private String endStation;
        private int stime;
        private int etime;

        public String getStartStation() {
            return startStation;
        }

        public void setStartStation(String startStation) {
            this.startStation = startStation;
        }

        public String getEndStation() {
            return endStation;
        }

        public void setEndStation(String endStation) {
            this.endStation = endStation;
        }

        public int getStime() {
            return stime;
        }

        public void setStime(int stime) {
            this.stime = stime;
        }

        public int getEtime() {
            return etime;
        }

        public void setEtime(int etime) {
            this.etime = etime;
        }
    }

    public static void main(String[] args) {
        UndergroundSystem undergroundSystem = new UndergroundSystem();
        undergroundSystem.checkIn(45, "Leyton", 3);
        undergroundSystem.checkIn(32, "Paradise", 8);
        undergroundSystem.checkIn(27, "Leyton", 10);
        undergroundSystem.checkOut(45, "Waterloo", 15);
        undergroundSystem.checkOut(27, "Waterloo", 20);
        undergroundSystem.checkOut(32, "Cambridge", 22);
        System.out.println(undergroundSystem.getAverageTime("Paradise", "Cambridge"));
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));
        undergroundSystem.checkIn(10, "Leyton", 24);
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));
        undergroundSystem.checkOut(10, "Waterloo", 38);
        undergroundSystem.getAverageTime("Leyton", "Waterloo");
    }
}
