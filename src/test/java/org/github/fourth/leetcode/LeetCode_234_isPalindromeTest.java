package org.github.fourth.leetcode;

import org.github.fourth.leetcode.common.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.github.fourth.leetcode.common.ListNode.build;
import static org.junit.jupiter.params.provider.Arguments.arguments;


@DisplayName("回文链表")
class LeetCode_234_isPalindromeTest {
    private final LeetCode_234_isPalindrome leetCode234IsPalindrome = new LeetCode_234_isPalindrome();


    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(ListNode head, boolean expectedResult) {
        boolean actResult = leetCode234IsPalindrome.isPalindrome(head);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(build(1, 2, 2, 1), true),
                arguments(build(1, 2), false)
        );
    }

}