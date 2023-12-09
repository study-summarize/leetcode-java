package org.github.fourth.leetcode;

import org.github.fourth.ListNodeVerifyUtil;
import org.github.fourth.leetcode.common.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.github.fourth.leetcode.common.ListNode.build;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("删除排序链表中的重复元素")
class LeetCode_083_deleteDuplicatesTest {
    private final LeetCode_083_deleteDuplicates leetCode083DeleteDuplicates = new LeetCode_083_deleteDuplicates();


    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(ListNode head, ListNode expectedResult) {
        ListNode actResult = leetCode083DeleteDuplicates.deleteDuplicates(head);
        Assertions.assertTrue(ListNodeVerifyUtil.equals(expectedResult, actResult));
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(build(1, 1, 1), build(1)),
                arguments(build(1, 1, 2), build(1, 2)),
                arguments(build(1, 1, 2, 3, 4, 5), build(1, 2, 3, 4, 5)),
                arguments(build(1), build(1)),
                arguments(build(1, 1, 2, 3, 3), build(1, 2, 3))
        );
    }
}
