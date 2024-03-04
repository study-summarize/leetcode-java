package org.github.fourth.leetcode;


import org.junit.jupiter.api.DisplayName;

@DisplayName("设计哈希集合")
class LeetCode_705_MyHashSetTest {

    private final LeetCode_705_MyHashSet testInstance = new LeetCode_705_MyHashSet();

    public void test() {
        testInstance.add(1);      // set = [1]
        testInstance.add(2);      // set = [1, 2]
        testInstance.contains(1); // 返回 True
        testInstance.contains(3); // 返回 False ，（未找到）
        testInstance.add(2);      // set = [1, 2]
        testInstance.contains(2); // 返回 True
        testInstance.remove(2);   // set = [1]
        testInstance.contains(2); // 返回 False ，（已移除）
    }

}