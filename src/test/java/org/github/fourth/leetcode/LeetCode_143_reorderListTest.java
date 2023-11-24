package org.github.fourth.leetcode;

import org.github.fourth.leetcode.common.ListNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.github.fourth.leetcode.common.ListNode.build;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("重排链表")
class LeetCode_143_reorderListTest {
    private final LeetCode_143_reorderList leetCode143ReorderList = new LeetCode_143_reorderList();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(ListNode head, ListNode expectedResult) {
        // todo: 如何验证？？？
        leetCode143ReorderList.reorderList(head);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(build(1, 2, 3, 4), build(1, 4, 2, 3)),
                arguments(build(1, 2, 3, 4, 5), build(1, 5, 2, 4, 3))
        );
    }

}