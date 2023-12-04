package org.github.fourth.leetcode;

import org.github.fourth.ListNodeVerifyUtil;
import org.github.fourth.leetcode.common.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.github.fourth.leetcode.common.ListNode.build;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("旋转链表")
class LeetCode_061_rotateRightTest {
    private final LeetCode_061_rotateRight leetCode061RotateRight = new LeetCode_061_rotateRight();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(ListNode head, int k, ListNode expectedResult) {
        ListNode actResult = leetCode061RotateRight.rotateRight(head, k);
        Assertions.assertTrue(ListNodeVerifyUtil.equals(expectedResult, actResult));
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(build(1, 2, 3, 4, 5), 2, build(4, 5, 1, 2, 3)),
                arguments(build(0, 1, 2), 4, build(2, 0, 1))
        );
    }

}