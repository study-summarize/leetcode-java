package org.github.fourth.leetcode;

import org.github.fourth.leetcode.common.ListNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.github.fourth.leetcode.common.ListNode.build;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("删除排序链表中的重复元素")
class LeetCode_083_deleteDuplicatesTest {
    private final LeetCode_083_deleteDuplicates leetCode083DeleteDuplicates = new LeetCode_083_deleteDuplicates();


    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(ListNode head, ListNode expectedResult) {
        // todo: 如何验证？？？
        ListNode actResult = leetCode083DeleteDuplicates.deleteDuplicates(head);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(build(1, 1, 2), build(1, 2)),
                arguments(build(1, 1, 2, 3, 3), build(1, 2, 3))
        );
    }
}
