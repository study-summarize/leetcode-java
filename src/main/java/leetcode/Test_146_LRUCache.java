package leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author jwang55
 */
public class Test_146_LRUCache extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public Test_146_LRUCache(int capacity) {
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
