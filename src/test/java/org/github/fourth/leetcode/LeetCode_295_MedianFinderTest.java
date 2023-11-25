package org.github.fourth.leetcode;

import org.junit.jupiter.api.DisplayName;

@DisplayName("数据流的中位数")
class LeetCode_295_MedianFinderTest {

//    @Test
    public void test() {
        LeetCode_295_MedianFinder medianFinder = new LeetCode_295_MedianFinder();
        medianFinder.addNum(1);    // arr = [1]
        medianFinder.addNum(2);    // arr = [1, 2]
        medianFinder.findMedian(); // 返回 1.5 ((1 + 2) / 2)
        medianFinder.addNum(3);    // arr[1, 2, 3]
        medianFinder.findMedian(); // return 2.0
    }
}