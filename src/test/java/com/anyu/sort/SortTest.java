package com.anyu.sort;

import com.anyu.sort.Sort;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.security.PublicKey;

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

    @Test
    public void mergeSortTest() {
        assertArrayEquals(result, sort.mergeSort());
    }

    @Test
    public void teee() {
        int[] a = new int[]{1, 2, 3};
        int[] b = new int[3];
        int[] c = new int[3];
        int i = 0;
        int j = 0;
        b[++j] = a[2];
        c[i++] = a[2];
        System.out.println(b[0] + "" + b[1] + "" + b[2]);
        System.out.println(c[0] + "" + c[1] + "" + c[2]);

    }

    @After
    public void afterTest() {
        System.out.println(sort.toString());
    }
}