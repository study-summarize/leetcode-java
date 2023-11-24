package org.github.fourth.leetcode;

import org.github.fourth.leetcode.common.ListNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.github.fourth.leetcode.common.ListNode.build;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("两数相加 II")
class LeetCode_445_addTwoNumbersTest {
    private final LeetCode_445_addTwoNumbers leetCode445AddTwoNumbers = new LeetCode_445_addTwoNumbers();


    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(ListNode l1, ListNode l2, ListNode expectedResult) {
        // todo: 如何验证？？？
        ListNode actResult = leetCode445AddTwoNumbers.addTwoNumbers(l1, l2);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(build(7, 2, 4, 3), build(5, 6, 4), build(7, 8, 0, 7)),
                arguments(build(2, 4, 3), build(5, 6, 4), build(8, 0, 7)),
                arguments(build(0), build(0), build(0))
        );
    }


}