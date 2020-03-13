package com.anyu.leetcode;

import java.util.Stack;

public class MinStack {
    /**
     * initialize your data structure here.
     */
    private Stack<Integer> min_stack = new Stack<>();
    private Stack<Integer> cur_stack = new Stack<>();

    public MinStack() {

    }

    public void push(int x) {
        cur_stack.push(x);
        if (min_stack.isEmpty() || x <= min_stack.peek()) {
            min_stack.push(x);
        } else {
            min_stack.push(min_stack.peek());
        }
    }

    public void pop() {
        cur_stack.pop();
        min_stack.pop();
    }

    public int top() {
        return cur_stack.peek();
    }

    public int getMin() {
        return min_stack.peek();
    }


}
