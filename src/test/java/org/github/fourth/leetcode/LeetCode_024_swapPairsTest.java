package org.github.fourth.leetcode;

import org.github.fourth.leetcode.common.ListNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.github.fourth.leetcode.common.ListNode.build;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("两两交换链表中的节点")
class LeetCode_024_swapPairsTest {
    private final LeetCode_024_swapPairs leetCode024SwapPairs = new LeetCode_024_swapPairs();


    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(ListNode head, ListNode expectedResult) {
        // todo: 如何验证？？？
        ListNode actResult = leetCode024SwapPairs.swapPairs(head);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(build(1, 2, 3, 4), build(2, 1, 4, 3)),
                arguments(build(), build()),
                arguments(build(1), build(1))
        );
    }


}