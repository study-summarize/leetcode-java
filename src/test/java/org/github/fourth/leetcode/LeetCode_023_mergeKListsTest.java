package org.github.fourth.leetcode;

import org.github.fourth.ListNodeVerifyUtil;
import org.github.fourth.leetcode.common.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("合并 K 个升序链表")
class LeetCode_023_mergeKListsTest {

    private final LeetCode_023_mergeKLists mergeKLists = new LeetCode_023_mergeKLists();
    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(ListNode[] lists, ListNode expectedResult) {
        ListNode actResult = mergeKLists.mergeKLists01(lists);
        Assertions.assertTrue(ListNodeVerifyUtil.equals(expectedResult, actResult));
    }

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(ListNode[] lists, ListNode expectedResult) {
        ListNode actResult = mergeKLists.mergeKListsExample(lists);
        Assertions.assertTrue(ListNodeVerifyUtil.equals(expectedResult, actResult));
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new ListNode[]{
                        ListNode.build(1, 4, 5),
                        ListNode.build(1, 3, 4),
                        ListNode.build(2, 6)
                }, ListNode.build(1, 1, 2, 3, 4, 4, 5, 6)),
                arguments(new ListNode[]{
                        ListNode.build()
                }, ListNode.build()),
                arguments(new ListNode[0], ListNode.build())
        );
    }

}