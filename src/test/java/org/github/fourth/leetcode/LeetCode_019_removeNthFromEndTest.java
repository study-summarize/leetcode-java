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

@DisplayName("删除链表的倒数第 N 个结点")
class LeetCode_019_removeNthFromEndTest {
    private final LeetCode_019_removeNthFromEnd leetCode019RemoveNthFromEnd = new LeetCode_019_removeNthFromEnd();


    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(ListNode head, int n, ListNode expectedResult) {
        ListNode actResult = leetCode019RemoveNthFromEnd.removeNthFromEnd(head, n);
        Assertions.assertTrue(ListNodeVerifyUtil.equals(expectedResult, actResult));
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(build(1, 2, 3, 4, 5), 2, build(1, 2, 3, 5)),
                arguments(build(1), 1, build()),
                arguments(build(1, 2), 1, build(1))
        );
    }
}