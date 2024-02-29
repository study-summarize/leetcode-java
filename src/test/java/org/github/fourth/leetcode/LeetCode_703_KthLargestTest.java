package org.github.fourth.leetcode;


import org.junit.jupiter.api.DisplayName;

@DisplayName("数据流中的第 K 大元素")
class LeetCode_703_KthLargestTest {

    public void test() {
        LeetCode_703_KthLargest testInstance = new LeetCode_703_KthLargest(3, new int[]{4, 5, 8, 2});
        testInstance.add(3);   // return 4
        testInstance.add(5);   // return 5
        testInstance.add(10);  // return 5
        testInstance.add(9);   // return 8
        testInstance.add(4);   // return 8
    }

}