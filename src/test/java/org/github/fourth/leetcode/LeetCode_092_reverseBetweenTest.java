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

@DisplayName("反转链表 II")
class LeetCode_092_reverseBetweenTest {
    private final LeetCode_092_reverseBetween leetCode092ReverseBetween = new LeetCode_092_reverseBetween();


    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(ListNode head, int left, int right, ListNode expectedResult) {
        ListNode actResult = leetCode092ReverseBetween.reverseBetween(head, left, right);
        Assertions.assertTrue(ListNodeVerifyUtil.equals(expectedResult, actResult));
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(build(1, 2, 3, 4, 5), 2, 4, build(1, 4, 3, 2, 5)),
                arguments(build(5), 1, 1, build(5))
        );
    }

}