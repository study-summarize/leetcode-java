package org.github.fourth.struct.linkedlist;

public interface LinkedList {
    // 增：
    /**
     * 在指定位置新增一个值为value的结点
     *
     * @param index 位置下标
     * @param value 具体值
     */
    void add(int index, int value);
    void addWithDummyNode(int index, int value);

    /**
     * 在链表尾部加一个结点
     */
    void append(int value);

    // 删：

    void removeByIndex(int index);
    void removeByIndexWithDummyNode(int index);
    void removeByValue(int value);

    // 改：
    void set(int index, int value);

    // 查：
    int get(int index);
    ListNode getNode(int index);
    int getLength();
    int getLengthByTraverse();

    /**
     * 判断链表是否有环
     */
    default boolean hasCycle() {
        return false;
    }
    /**
     * 获取链表中倒数第K个的结点
     */
    default ListNode getKthFromEnd(int k) {
        throw new UnsupportedOperationException();
    }
    /**
     * 根据双指针的方法找到链表的中间结点
     * note：如果链表长度为偶数，则返回中间最大的结点
     * DummyNode结点技巧
     */
    ListNode findMiddleNode();
}
