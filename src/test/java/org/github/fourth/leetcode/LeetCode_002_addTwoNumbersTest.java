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

@DisplayName("两数相加")
class LeetCode_002_addTwoNumbersTest {
    private final LeetCode_002_addTwoNumbers leetCode002AddTwoNumbers = new LeetCode_002_addTwoNumbers();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(ListNode l1, ListNode l2, ListNode expectedResult) {
        ListNode actResult = leetCode002AddTwoNumbers.test(l1, l2);
        Assertions.assertTrue(ListNodeVerifyUtil.equals(expectedResult, actResult));
    }

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(ListNode l1, ListNode l2, ListNode expectedResult) {
        ListNode actResult = leetCode002AddTwoNumbers.addTwoNumbers(l1, l2);
        Assertions.assertTrue(ListNodeVerifyUtil.equals(expectedResult, actResult));
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(build(2, 4, 3), build(5, 6, 4), build(7, 0, 8)),
                arguments(build(0), build(0), build(0)),
                arguments(build(9, 9, 9, 9, 9, 9, 9), build(9, 9, 9, 9), build(8, 9, 9, 9, 0, 0, 0, 1))
        );
    }
}
