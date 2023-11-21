package org.github.fourth.leetcode;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

/**
 * 不使用任何内建的哈希表库设计一个哈希映射（HashMap）。
 * 实现 MyHashMap 类：
 * - MyHashMap() 用空映射初始化对象
 * - void put(int key, int value) 向 HashMap 插入一个键值对 (key, value) 。如果 key 已经存在于映射中，则更新其对应的值 value 。
 * - int get(int key) 返回特定的 key 所映射的 value ；如果映射中不包含 key 的映射，返回 -1 。
 * - void remove(key) 如果映射中存在 key 的映射，则移除 key 和它所对应的 value 。
 */
public class LeetCode_706_MyHashMap {

    private static final int DEFAULT_CAPACITY = 10_0000;
    private static final double DEFAULT_LOAD_FACTOR = 0.75;

    private double loadFactor;
    private int initCapacity;

    // 链表数组
    private Node[] table;
    private int size;

    // 链表节点
    private static class Node {
        int key;
        int value;
        Node next;

        public Node(int key, int value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public LeetCode_706_MyHashMap() {
        this(DEFAULT_LOAD_FACTOR, DEFAULT_CAPACITY);
    }

    public LeetCode_706_MyHashMap(double loadFactor, int initCapacity) {
        this.loadFactor = loadFactor;
        this.initCapacity = initCapacity;
        this.table = new Node[initCapacity];
    }

    public void put(int key, int value) {
        if (this.size > (int) (this.loadFactor * this.initCapacity)) {
            resize();
        }

        int hashCode = hash(key);
        Node node = this.table[hashCode];

        Node newNode = new Node(key, value, null);
        if (node == null) {
            this.table[hashCode] = newNode;
        } else {
            while (node != null) {
                // key存在时
                if (node.key == key) {
                    node.value = value;
                    return;
                }
                if (node.next == null) {
                    node.next = newNode;
                }
                node = node.next;
            }
        }
        this.size++;
    }

    public int get(int key) {
        int hashCode = hash(key);
        Node node = this.table[hashCode];
        while (node != null) {
            if (node.key == key) {
                return node.value;
            }
            node = node.next;
        }
        return -1;
    }

    @SuppressFBWarnings("RCN_REDUNDANT_NULLCHECK_OF_NONNULL_VALU")
    public void remove(int key) {
        int hashCode = hash(key);
        Node node = this.table[hashCode];
        if (node == null) {
            return;
        }
        while (node != null) {
            // node 是链表唯一节点
            if (node.next == null) {
                table[hashCode] = null;
                return;
            }

            if (node.key == key) {
                node.value = node.next.value;
                node.next = node.next.next;
                return;
            }
            node = node.next;
        }
    }

    private int hash(int key) {
        return key % this.initCapacity;
    }

    private void resize() {
        int newCapacity = this.initCapacity * 2;
        this.initCapacity = newCapacity;
        Node[] newTable = new Node[newCapacity];
        // rehash
        for (Node node : this.table) {
            while (node != null) {
                int hashCode = hash(node.key);
                if (newTable[hashCode] != null) {
                    Node head = newTable[hashCode];
                    while (head.next != null) {
                        head = head.next;
                    }
                    Node newNode = new Node(node.key, node.value, null);
                    head.next = newNode;
                } else {
                    Node newNode = new Node(node.key, node.value, null);
                    newTable[hashCode] = newNode;
                }
                node = node.next;
            }
        }
        this.table = newTable;
    }
}
