package org.github.fourth.leetcode;

import org.github.fourth.leetcode.common.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 */
public class LeetCode_445_addTwoNumbers {
    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public ListNode addTwoNumbers01(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode dummyNode = new ListNode();
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();

        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            int num1 = stack1.pop();
            int num2 = stack2.pop();
            int sum = num1 + num2 + carry;
            int value = sum % 10;
            carry = sum / 10;

            ListNode newNode = new ListNode(value);
            ListNode temp = dummyNode.next;
            dummyNode.next = newNode;
            newNode.next = temp;
        }

        while (!stack1.isEmpty()) {
            int sum = stack1.pop() + carry;
            int value = sum % 10;
            carry = sum / 10;

            ListNode newNode = new ListNode(value);
            ListNode temp = dummyNode.next;
            dummyNode.next = newNode;
            newNode.next = temp;
        }

        while (!stack2.isEmpty()) {
            int sum = stack2.pop() + carry;
            int value = sum % 10;
            carry = sum / 10;

            ListNode newNode = new ListNode(value);
            ListNode temp = dummyNode.next;
            dummyNode.next = newNode;
            newNode.next = temp;
        }

        if (carry != 0) {
            ListNode newNode = new ListNode(carry);
            ListNode temp = dummyNode.next;
            dummyNode.next = newNode;
            newNode.next = temp;
        }
        return dummyNode.next;
    }

    /**
     * 对上面的代码简化一下
     */
    public ListNode addTwoNumbers02(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode dummyNode = new ListNode();
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();

        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int num1 = stack1.isEmpty() ? 0 : stack1.pop();
            int num2 = stack2.isEmpty() ? 0 : stack2.pop();
            int sum = num1 + num2 + carry;
            int value = sum % 10;
            carry = sum / 10;

            ListNode newNode = new ListNode(value);
            ListNode temp = dummyNode.next;
            dummyNode.next = newNode;
            newNode.next = temp;
        }
        return dummyNode.next;
    }
}
