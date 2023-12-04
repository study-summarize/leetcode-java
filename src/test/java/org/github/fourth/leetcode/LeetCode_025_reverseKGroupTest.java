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

@DisplayName("K 个一组翻转链表")
class LeetCode_025_reverseKGroupTest {
    private final LeetCode_025_reverseKGroup leetCode025ReverseKGroup = new LeetCode_025_reverseKGroup();


    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(ListNode head, int k, ListNode expectedResult) {
        ListNode actResult = leetCode025ReverseKGroup.reverseKGroup(head, k);
        Assertions.assertTrue(ListNodeVerifyUtil.equals(expectedResult, actResult));
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(build(1, 2, 3, 4, 5), 2, build(2, 1, 4, 3, 5)),
                arguments(build(1, 2, 3, 4, 5), 3, build(3, 2, 1, 4, 5))
        );
    }


}