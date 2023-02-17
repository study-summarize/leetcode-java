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
        }
        private Map<Integer, DoubleListNode> map;
        private int capacity;

        public LRUCache(int capacity) {
            this.map = new HashMap<>();
            this.capacity = capacity;
        }

        public int get(int key) {
            return 0;
        }

        public void put(int key, int value) {
        }

    }
}
