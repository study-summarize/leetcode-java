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
}
