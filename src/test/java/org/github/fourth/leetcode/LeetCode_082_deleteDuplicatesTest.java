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

@DisplayName("删除排序链表中的重复元素 II")
class LeetCode_082_deleteDuplicatesTest {
    private final LeetCode_082_deleteDuplicates leetCode082DeleteDuplicates = new LeetCode_082_deleteDuplicates();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(ListNode head, ListNode expectedResult) {
        ListNode actResult = leetCode082DeleteDuplicates.deleteDuplicates(head);
        Assertions.assertTrue(ListNodeVerifyUtil.equals(expectedResult, actResult));
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(build(1, 2, 3, 3, 4, 4, 5), build(1, 2, 5)),
                arguments(build(1, 1, 1, 2, 3), build(2, 3))
        );
    }

}