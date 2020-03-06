package com.anyu.sort;

import com.anyu.sort.Sort;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SortTest {
    private int[] nums;
    private int[] result;
    private Sort sort;
    @Before
    public void beforeTest(){
        nums=new int[]{1,2,3,4,245,78,296,44,14};
        result=new int[]{296,245,78,44,14,4,3,2,1};
        sort=new Sort(nums);
    }

    @Test
    public void bubbleSort() {
       assertArrayEquals(result,sort.bubbleSort());
    }

    @Test
    public void selectionSort() {
        assertArrayEquals(result, sort.selectionSort());

    }

    @Test
    public void insertionSort() {
        assertArrayEquals(result, sort.insertionSort());
    }

    @Test
    public void quickSortTest() {
        assertArrayEquals(result, sort.quickSort());
    }

    @After
    public void afterTest() {
        System.out.println(sort.toString());
    }
}