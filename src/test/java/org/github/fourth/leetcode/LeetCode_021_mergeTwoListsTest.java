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

@DisplayName("合并两个有序链表")
class LeetCode_021_mergeTwoListsTest {
    private final LeetCode_021_mergeTwoLists leetCode021MergeTwoLists = new LeetCode_021_mergeTwoLists();


    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(ListNode list1, ListNode list2, ListNode expectedResult) {
        ListNode actResult = leetCode021MergeTwoLists.mergeTwoLists(list1, list2);
        Assertions.assertTrue(ListNodeVerifyUtil.equals(expectedResult, actResult));
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(build(1, 2, 4), build(1, 3, 4), build(1, 1, 2, 3, 4, 4)),
                arguments(build(), build(), build()),
                arguments(build(), build(0), build(0))
        );
    }
}
