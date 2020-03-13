package com.anyu.leetcode;

import java.util.Stack;

/**
 * 加减乘除和括号的简易计算器
 */
public class SimpleCalculater {
//    public int calculater(String exp){
//        int res=0;
//        Stack<Integer> digStack=new Stack<>();//数字栈
//        Stack<Character> operStack=new Stack<>();//符号栈
//        int len=exp.length();
////        表达式正却才加入计算
//        if (isExp(exp)){
//            for (int i = 0; i <len ; i++) {
//                if (exp.charAt(i))
//            }
//        }else {
//
//        }
//        return 0;
//    }

    /**
     * 判断是否是正确表达式
     *
     * @param exp
     * @return
     */
    public static boolean isExp(String exp) {
        if (exp == null || exp.length() < 1) {
            return false;
        }
        int len = exp.length();
        Stack<Character> expStack = new Stack<>();
        int sig = 0;
        for (int i = 0; i < len; i++) {
            char ch = exp.charAt(i);
            //不能以* / 开头
            if (expStack.isEmpty() && (ch == '*' || ch == '/')) {
                return false;
            }
            //')'不能再‘(’前
            if (sig < 0) {
                return false;
            }
            if (!expStack.isEmpty()) {
                // * / + - 不能两两连续
                if (ch == ('*' | '/' | '+' | '-') && expStack.peek() == ('*' | '/' | '+' | '-')) {
                    return false;
                }
                //'('只能在‘+’, '-',数字之前；
                if (expStack.peek() == '(') {
                    if (!Character.isDigit(ch)) {
                        if (ch == ('*' | '/')) {
                            return false;
                        }
                    }
                }
            }
            if (ch == '(') {
                sig++;//括号数增加
            }
            //括号
            if (ch == ')') {
                sig--;//括号数减少
            }
            expStack.push(ch);
        }
        //括号匹配
        if (sig != 0) {
            return false;
        }
        if (!expStack.isEmpty()) {
            //单个字符只能是数字
            if (len < 2 && Character.isDigit(expStack.peek())) {
                return false;
            }
            //判断是否以数字，）结尾
            while (expStack.peek() == ')') {
                expStack.pop();
            }
            return Character.isDigit(expStack.peek());
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "(+(9*9*9)/9)";
        System.out.println(isExp(s1));
    }
}
