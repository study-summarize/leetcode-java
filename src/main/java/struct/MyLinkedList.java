package struct;

/**
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

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.add(0, 2);
        list.add(1, 3);
        list.add(2, 1);
        list.add(3, 6);
        list.add(4, 5);
        // 5
        System.out.println(list.length);
        System.out.println(list.getLengthByTraverse());

        // index = 3, value = 6
        System.out.println(list.get(3));
        // index = 2, value = 1
        System.out.println(list.get(2));

        list.add(3, 7);
        // index = 3, value 7; index = 4, value = 6
        System.out.println(list.get(3));
        System.out.println(list.get(4));

        list.append(100);
        // index = 6, value = 100
        System.out.println(list.get(6));

        list.set(5, 1000);
        // index = 5, value = 1000
        System.out.println(list.get(5));

        // 7
        System.out.println(list.length);
        list.removeByIndex(3);
        // 2 3 1 6 1000 100 null
        System.out.println(list.get(3));
        System.out.println(list.get(4));
        System.out.println(list.get(5));

        list.removeByIndex(0);
        // 3 1 6 1000 100 null
        System.out.println(list.get(3));
        System.out.println(list.get(4));
        // 5
        System.out.println(list.length);
        System.out.println(list.getLengthByTraverse());
    }
}