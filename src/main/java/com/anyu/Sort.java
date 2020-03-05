package com.anyu;

import java.util.Arrays;

public class Sort {
    private int[] nums;
    private int length;
    public Sort(int[] nums){
        this.nums=nums;
    }

    /**
     * 冒泡排序 有小到大
     */
    public int[] bubbleSort(){
        int times;
        boolean need=true;//判断后面数据是否需要排序
        int length=nums.length;
        //每一次找的最小数，放最后，n个数就进行n-1次循环
        for (times=1; times< length; times++) {
            if (need == false)
                break;
            need = false;
            for (int pointer = 1; pointer <= length - times; pointer++) {
                if (nums[pointer - 1] < nums[pointer]) {
                    need = true;//顺序变动，需要再次排序
                    int tem = nums[pointer];
                    nums[pointer] = nums[pointer - 1];
                    nums[pointer - 1] = tem;
                }
            }
        }
        return nums;
    }
    /**
     * 选择排序，每次选择最大的依次放前面
     */
    public int[] selectionSort(){
        int length=nums.length;
        int tem=0;
        int max_index;//最大值下标
        //tail 作为已排序的尾，可做排序次数
        for (int tail = 0; tail <length-1 ; tail++) {
            max_index = tail;
            for (int pointer = tail + 1; pointer < length; pointer++) {
                if (nums[max_index] < nums[pointer]) {
                    max_index=pointer;
                }
            }
            tem = nums[max_index];
            nums[max_index] = nums[tail];
            nums[tail] = tem;
        }
        return nums;
    }

    /**
     * 插入排序,由大到小
     */
    public int[] insertionSort(){
        int length=nums.length;
        int tem;
        //tail表示已排好序的尾部
        for ( int tail=0;tail<length-1;tail++){
            tem=nums[tail+1];
            while (tail>=0 && tem > nums[tail] ){//tail>=0 与 tem > nums[tail] 两个判断条件不能互换
                nums[tail+1]=nums[tail];
                tail--;
            }
            nums[tail+1]=tem;
        }
        return nums;
    }

    public void quikSort(){

    }






    @Override
    public String toString() {
        return "Sort{" +
                "nums=" + Arrays.toString(nums) +
                '}';
    }
}
