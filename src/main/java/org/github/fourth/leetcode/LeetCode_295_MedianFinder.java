package org.github.fourth.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 中位数是有序整数列表中的中间值。如果列表的大小是偶数，则没有中间值，中位数是两个中间值的平均值。
 * - 例如 arr = [2,3,4] 的中位数是 3 。
 * - 例如 arr = [2,3] 的中位数是 (2 + 3) / 2 = 2.5 。
 * 实现 MedianFinder 类:
 * - MedianFinder() 初始化 MedianFinder 对象。
 * - void addNum(int num) 将数据流中的整数 num 添加到数据结构中。
 * - double findMedian() 返回到目前为止所有元素的中位数。与实际答案相差 10-5 以内的答案将被接受。
 */
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
