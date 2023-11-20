package org.github.fourth.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 设计一个支持`push`，`pop`，`top`操作，并能在常数时间内检索到最小元素的栈。
 * 实现`MinStack`类:
 * - `MinStack()`初始化堆栈对象。
 * - `void push(int val)`将元素val推入堆栈。
 * - `void pop()`删除堆栈顶部的元素。
 * - `int top()`获取堆栈顶部的元素。
 * - `int getMin()`获取堆栈中的最小元素。
 */
public class LeetCode_155_MinStack {

    /**
     * 最小元素保存：
     * 利用栈来记录当时状态下的最小值！！！
     */
    private final Deque<Integer> minStack;
    private final Deque<Integer> stack;

    public LeetCode_155_MinStack() {
        minStack = new LinkedList<>();
        stack = new LinkedList<>();
        // 为最小栈设置一个默认值对后面很有好处
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.push(val);
        // 更新最小栈数据
        minStack.push(Math.min(val, minStack.peek()));
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
