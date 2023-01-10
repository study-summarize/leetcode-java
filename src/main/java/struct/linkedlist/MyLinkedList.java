package struct.linkedlist;

/**
 * 头插法：
 * 将俩个相邻节点旋转：
 *
 * @author jwang55
 */
public class MyLinkedList {
    // field
    ListNode head;
    int length;

    // Constructor
    public MyLinkedList() {
    }

    public MyLinkedList(ListNode head) {
        this.head = head;
    }

    // Method
    public int get(int index) {
        return getNode(index).val;
    }

    public ListNode getNode(int index) {
        preCheck(index, this.length - 1);

        ListNode cur = this.head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    public void add(int index, int value) {
        preCheck(index, this.length);

        // Build new Node
        ListNode newNode = new ListNode(value);
        this.length++;
        if (index == 0) {
            head = newNode;
            return;
        }
        // Search
        ListNode preNode = getNode(index - 1);
        ListNode curNode = preNode.next;

        // change Linked list structure
        preNode.next = newNode;
        newNode.next = curNode;
    }

    public void addWithDummyNode(int index, int value) {
        preCheck(index, this.length);

        // Build new Node
        ListNode newNode = new ListNode(value);
        this.length++;

        // Build Dummy Node
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode preNode = dummyNode;
        while (index > 0) {
            preNode = preNode.next;
            index--;
        }
        // Search
        ListNode curNode = preNode.next;

        // change Linked list structure
        preNode.next = newNode;
        newNode.next = curNode;

        this.head = dummyNode.next;
    }

    private void preCheck(int index, int restriction) {
        if (index < 0 || index > restriction) {
            throw new RuntimeException(String.format("The index %s is out of index, the restriction for check %s", index, this.length));
        }
    }

    public void append(int value) {
        add(this.length, value);
    }

    public void set(int index, int value) {
        // Search
        ListNode node = getNode(index);
        node.val = value;
    }

    public void removeByIndex(int index) {
        preCheck(index, this.length - 1);
        if (index == 0) {
            this.length--;
            ListNode cur = head;
            head = cur.next;
            cur = null; // note: help GC
            return;
        }
        // Search
        ListNode preNode = getNode(index - 1);
        ListNode cur = preNode.next;
        // change Linked list structure
        preNode.next = cur.next;
        this.length--;
    }

    public void removeByIndexWithDummyNode(int index) {
        preCheck(index, this.length - 1);
        this.length--;

        // Build Dummy Node
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode preNode = dummyNode;
        while (index > 0) {
            preNode = preNode.next;
            index--;
        }

        // change Linked list structure
        ListNode nextNode = preNode.next.next;
        preNode.next = nextNode;

        this.head = dummyNode.next;
    }

    public void removeByValue(int value) {

    }

    public int getLength() {
        return this.length;
    }

    public int getLengthByTraverse() {
        ListNode cur = head;
        int length = 0;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }
}