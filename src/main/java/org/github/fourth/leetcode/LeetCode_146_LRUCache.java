package org.github.fourth.leetcode;

import org.github.fourth.Top100;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * - LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * - int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * - void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 */
@Top100
public class LeetCode_146_LRUCache extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public LeetCode_146_LRUCache(int capacity) {
        super(capacity, 0.75f, true);
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > this.capacity;
    }

    private static class LRUCache {
        private static class DoubleListNode {
            DoubleListNode before;
            DoubleListNode after;
            int key;
            int value;
            DoubleListNode(int key, int value) {
                this.key = key;
                this.value = value;
                this.before = null;
                this.after = null;
            }
        }
        private Map<Integer, DoubleListNode> map;
        private int capacity;
        private DoubleListNode dummyHead;
        private DoubleListNode dummyTail;

        public LRUCache(int capacity) {
            this.map = new HashMap<>();
            this.capacity = capacity;
            this.dummyHead = new DoubleListNode(-1, -1);
            this.dummyTail = new DoubleListNode(-1, -1);
            this.dummyHead.after = this.dummyTail;
            this.dummyTail.before = this.dummyHead;
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;

            }
            DoubleListNode curNode = map.get(key);
            // 拆除之前的前后节点链接
            curNode.before.after = curNode.after;
            curNode.after.before = curNode.before;
            // 把get到的节点移到双向链表尾部
            curNode.before = this.dummyTail.before;
            curNode.before.after = curNode;
            this.dummyTail.before = curNode;
            curNode.after = this.dummyTail;

            return curNode.value;
        }

        public void put(int key, int value) {
            if (this.get(key) != -1) {
                map.get(key).value = value;
                return;
            }

            // 新节点插入：1、没到capacity；2、到capacity
            if (map.size() == capacity) {
                // 删除map对应节点和双向链表节点（最老的）
                map.remove(this.dummyHead.after.key);
                this.dummyHead.after = this.dummyHead.after.after;
                this.dummyHead.after.before = this.dummyHead;
            }
            DoubleListNode newNode = new DoubleListNode(key, value);
            map.put(key, newNode);
            // 把插入的节点移动到尾部
            newNode.before = this.dummyTail.before;
            newNode.before.after = newNode;
            this.dummyTail.before = newNode;
            newNode.after = this.dummyTail;

        }

    }
}
