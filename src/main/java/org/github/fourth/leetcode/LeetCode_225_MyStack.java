package org.github.fourth.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（`push`、`top`、`pop`和`empty`）。
 * 实现`MyStack`类：
 * - `void push(int x)`将元素 x 压入栈顶。
 * - `int pop()`移除并返回栈顶元素。
 * - `int top()`返回栈顶元素。
 * - `boolean empty()`如果栈是空的，返回`true`；否则，返回`false`。
 * **注意：**
 * - 你只能使用队列的基本操作 —— 也就是`push to back`、`peek/pop from front`、`size`和`is empty`这些操作。
 * - 你所使用的语言也许不支持队列。你可以使用 list （列表）或者 deque（双端队列）来模拟一个队列, 只要是标准的队列操作即可。
 */
public class LeetCode_225_MyStack {

    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();

    public LeetCode_225_MyStack() {

    }

    public void push(int x) {
        // 先放入临时队列
        queue2.add(x);
        // 将正式队列的元素，全部转移到临时队列
        while (!queue1.isEmpty()) {
            queue2.add(queue1.poll());
        }

        // 将俩个队列进行交换
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

    }

    public int pop() {
        return queue1.poll();
    }

    public int top() {
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
