package com.anyu.sort;

import java.util.Arrays;

public class Sort {
    private int[] nums;
    private int length;
    public Sort(int[] nums){
        this.nums = nums;
        this.length = nums.length;
    }

    /**
     * 1.冒泡排序 由大到小
     */
    public int[] bubbleSort(){
        int times;
        boolean need=true;//判断后面数据是否需要排序
        //每一次找的最小数，放最后，n个数就进行n-1次循环
        for (times=1; times< length; times++) {
            if (need == false)
                break;
            need = false;
            for (int pointer = 1; pointer <= length - times; pointer++) {
                if (nums[pointer - 1] < nums[pointer]) {
                    need = true;//顺序变动，需要再次排序
                    swap(pointer, pointer - 1);
                }
            }
        }
        return nums;
    }

    /**
     * 2.选择排序，每次选择最大的依次放前面
     */
    public int[] selectionSort(){
        int max_index;//最大值下标
        //tail 作为已排序的尾，可做排序次数
        for (int tail = 0; tail <length-1 ; tail++) {
            max_index = tail;
            for (int pointer = tail + 1; pointer < length; pointer++) {
                if (nums[max_index] < nums[pointer]) {
                    max_index=pointer;
                }
            }
            swap(max_index, tail);
        }
        return nums;
    }

    /**
     * 3.插入排序,由大到小
     */
    public int[] insertionSort(){
        int tem;
        //tail表示已排好序的尾部
        for ( int tail=0;tail<length-1;tail++){
            tem = nums[tail + 1];
            while (tail >= 0 && tem > nums[tail]) {//tail>=0 与 tem > nums[tail] 两个判断条件不能互换
                nums[tail + 1] = nums[tail];
                tail--;
            }
            nums[tail + 1] = tem;
        }
        return nums;
    }

    /**
     * 4.快速排序
     * quickS方法递归调用自身，处理被基准分割的数组
     * quick 定义基准pivot，并将大于基准的放到基准右边，小于放到左边
     */
    public int[] quickSort() {
        int head = 0;
        int tail = length - 1;
        quickS(head, tail);
        return nums;
    }

    /**
     * 方法递归调用自身，处理被基准分割的数组
     *
     * @param head
     * @param tail
     */
    public void quickS(int head, int tail) {
        if (head < tail) {
            int pivot = quick(head, tail);
            quickS(head, pivot - 1);
            quickS(pivot + 1, tail);
        }
    }

    /**
     * 定义基准pivot，并将大于基准的放到基准右边，小于放到左边
     *
     * @param head 数组头指针
     * @param tail 数组尾指针
     * @return
     */
    public int quick(int head, int tail) {
        int pivot = head;//初始化基准，赋值头指针
        while (head < tail) {
            while (head < tail && nums[pivot] >= nums[tail])
                tail--;
            swap(pivot, tail);
            pivot = tail;
            while (head < tail && nums[pivot] < nums[head])
                head++;
            swap(pivot, head);
            pivot = head;
        }
        return pivot;
    }

    /**
     * 归并排序
     *
     * @return
     */
    public int[] mergeSort() {
        mergeS(0, length - 1);
        return nums;
    }

    public void mergeS(int left, int right) {
        if (left < right) {
            int mid = (right + left) / 2;
            mergeS(left, mid);//递归分割左边
            mergeS(mid + 1, right);//递归分割右边
            merge(left, mid, right);//合并排序
        }
    }

    public void merge(int left, int mid, int right) {
        int[] tem = new int[length];//存放排好的数组
        int pointer = left; //存放指针
        int P1 = left; //左游标指针
        int P2 = mid + 1;//右游标指针
        //左边有序和数组右边有序数组有未比较的情况下，相互比较排序
        while (P1 <= mid && P2 <= right) {
            if (nums[P1] > nums[P2]) {
                tem[pointer++] = nums[P1++];
            } else {
                tem[pointer++] = nums[P2++];
            }

        }
        //如果左边没有排完，将左边有序复制到暂存数组
        while (P1 <= mid)
            tem[pointer++] = nums[P1++];
        //右边同上
        while (P2 <= right)
            tem[pointer++] = nums[P2++];
//        将排好序的合并到原来数组
        for (int i = left; i <= right; i++) {
            nums[i] = tem[i];
        }
    }

    /**
     * 数组前后值交换
     *
     * @param front
     * @param behand
     */
    public void swap(int front, int behand) {
        int tem = 0;
        tem = nums[front];
        nums[front] = nums[behand];
        nums[behand] = tem;
    }

    @Override
    public String toString() {
        return "Sort{" +
                "nums=" + Arrays.toString(nums) +
                '}';
    }
}
