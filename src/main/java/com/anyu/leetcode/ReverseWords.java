package com.anyu.leetcode;

import java.util.Stack;

/**
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * 为简单起见，标点符号和普通字母一样处理。
 * 例如输入字符串"I am a student. "，则输出"student. a am I"。
 */
public class ReverseWords {
    //    public  String reverseWords(String s) {
//        String[] strs=s.strip().split(" +");
//        if (strs==null ||strs.length<1)
//            return String.valueOf(strs);
//        reverse(strs,0,strs.length-1);
//        return String.valueOf(strs);
//    }
//    public void reverse(String[] strs,int left,int right){
//        if (left==right)
//            return;
//        while (left<right){
//            int mid=(left+right)/2;
//            reverse(strs,left,mid);
//            reverse(strs,mid+1,right);
//            meger(strs,left,mid,right);
//        }
//    }
//    public void meger(String[] strs,int left,int mid,int right){
//        String[] leftStrs;
//        String[] rightStrs;
//        leftStrs= Arrays.copyOfRange(strs,left,mid);
//        rightStrs=Arrays.copyOfRange(strs,mid+1,right);
//        int cur=left;
//        for (String str : rightStrs)
//            strs[cur++]=str;
//        for (String str : leftStrs)
//            strs[cur++]=str;
//    }
    public String reverseWords(String s) {
        String[] strs = s.strip().split(" ");
        Stack<String> stack = new Stack<String>();
        for (String str : strs) {
            stack.push(str);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty())
            sb.append(stack.pop()).append(" ");
        return sb.toString().strip();
    }

    public static void main(String[] args) {

        System.out.println(new ReverseWords().reverseWords("the sky is blue"));
    }
}
