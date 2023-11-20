package org.github.fourth.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（`push`、`pop`、`peek`、`empty`）：
 * 实现`MyQueue`类：
 * - `void push(int x)`将元素 x 推到队列的末尾
 * - `int pop()`从队列的开头移除并返回元素
 * - `int peek()`返回队列开头的元素
 * - `boolean empty()`如果队列为空，返回`true`；否则，返回`false`
 * 说明：
 * - 你只能使用标准的栈操作 —— 也就是只有`push to top`,`peek/pop from top`,`size`, 和`is empty`操作是合法的。
 * - 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 */
public class LeetCode_232_MyQueue {
    /**
     * push时，都往stack1放
     * pop时，先看stack2有没有元素
     * （1）stack2有元素，直接将栈顶元素拿出
     * （2）stack2无元素，依次将stack1的元素放入stack2中
     * peek时，先看stack2有没有元素
     * （1）stack2有元素，直接将栈顶元素拿出
     * （2）stack2无元素，依次将stack1的元素放入stack2中
     * empty时，只有stack1、stack2都为空，才返回true
     */
    private final Deque<Integer> stack1 = new LinkedList<>();
    private final Deque<Integer> stack2 = new LinkedList<>();

    public LeetCode_232_MyQueue() {

    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        }

        // 将stack1元素拿到stack2中
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        return stack2.pop();
    }

    public int peek() {
        if (!stack2.isEmpty()) {
            return stack2.peek();
        }

        // 将stack1元素拿到stack2中
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        return stack2.peek();
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
