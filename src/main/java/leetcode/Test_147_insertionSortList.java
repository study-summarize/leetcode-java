package leetcode;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import struct.linkedlist.ListNode;

/**
 * @author jwang55
 */
public class Test_147_insertionSortList {

    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummyNode = new ListNode(-1);

        while (head != null) {
            ListNode node = dummyNode;
            // 比较
            while (node.next != null && node.next.val < head.val) {
                node = node.next;
            }
            // 拆入此时head的节点
            ListNode temp = head.next;
            head.next = node.next;
            node.next = head;
            head = temp;
        }

        return dummyNode.next;
    }
}
