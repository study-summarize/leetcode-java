package org.github.fourth.leetcode;

import org.github.fourth.leetcode.common.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.github.fourth.leetcode.common.ListNode.build;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("环形链表 II")
class LeetCode_142_detectCycleTest {
    private final LeetCode_142_detectCycle leetCode142DetectCycle = new LeetCode_142_detectCycle();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(ListNode head, ListNode expectedResult) {
        ListNode actResult = leetCode142DetectCycle.detectCycle(head);
        // 有环咋办
        if (expectedResult == null) {
            Assertions.assertNull(actResult);
        } else {
            Assertions.assertEquals(expectedResult.val, actResult.val);
        }
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(build(new int[]{3, 2, 0, -4}, 1), build(new int[]{2, 0, -4}, 0)),
                arguments(build(new int[]{1, 2}, 0), build(new int[]{1, 2}, 0)),
                arguments(build(new int[]{1}), null)
        );
    }
}