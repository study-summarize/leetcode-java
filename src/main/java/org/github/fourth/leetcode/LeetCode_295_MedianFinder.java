package org.github.fourth.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class LeetCode_295_MedianFinder {

    // 最大堆存放较小元素
    private Queue<Integer> maxHeap;
    // 最小堆存放较大元素
    private Queue<Integer> minHeap;

    public LeetCode_295_MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // num 小于最大堆的堆顶
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num);
            // 判断maxHeap、minHeap的size差距不能超过1(maxHeap可能比minHeap多俩个元素)
            if (maxHeap.size() > minHeap.size() + 1) {
                int elementFromMaxHeap = maxHeap.poll();
                minHeap.offer(elementFromMaxHeap);
            }
        } else {
            minHeap.offer(num);
            // 判断maxHeap、minHeap的size差距不能超过1(minHeap可能比MaxHeap最多多一个元素)
            if (minHeap.size() > maxHeap.size()) {
                int elementFromMinHeap = minHeap.poll();
                maxHeap.offer(elementFromMinHeap);
            }
        }
    }

    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }
        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}
