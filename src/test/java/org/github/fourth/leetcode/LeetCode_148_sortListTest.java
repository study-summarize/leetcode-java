package org.github.fourth.leetcode;

import org.github.fourth.leetcode.common.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("排序链表")
class LeetCode_148_sortListTest {
    private final LeetCode_148_sortList sortList = new LeetCode_148_sortList();

//    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(ListNode head, ListNode expectedResult) {
        ListNode actResult = sortList.sortList(head);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(ListNode.build(4, 2, 1, 3), ListNode.build(1, 2, 3, 4)),
                arguments(ListNode.build(-1, 5, 3, 4, 0), ListNode.build(-1, 0, 3, 4, 5)),
                arguments(ListNode.build(), ListNode.build())
        );
    }
}