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

@DisplayName("环形链表 I")
class LeetCode_141_hasCycleTest {
    private final LeetCode_141_hasCycle leetCode141HasCycle = new LeetCode_141_hasCycle();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(ListNode head, boolean expectedResult) {
        boolean actResult = leetCode141HasCycle.hasCycle01(head);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(build(new int[]{3, 2, 0, -4}, 1), true),
                arguments(build(new int[]{1, 2}, 0), true),
                arguments(build(new int[]{1}), false)
        );
    }
}