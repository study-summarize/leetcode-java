package org.github.fourth.leetcode;

import org.github.fourth.ListNodeVerifyUtil;
import org.github.fourth.leetcode.common.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.Function;
import java.util.stream.Stream;

import static org.github.fourth.leetcode.common.ListNode.build;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("链表的中间结点")
class LeetCode_876_middleNodeTest {

    private final LeetCode_876_middleNode leetCode876MiddleNode = new LeetCode_876_middleNode();

    @DisplayName("暴力解法")
    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(ListNode head, ListNode expectedResult) {
        commonTest(expectedResult, x -> x.middleNode01(head));
    }

    @DisplayName("快慢指针")
    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test02(ListNode head, ListNode expectedResult) {
        commonTest(expectedResult, x -> x.middleNode02(head));
    }

    private void commonTest(ListNode expectedResult, Function<LeetCode_876_middleNode, ListNode> function) {
        ListNode result = function.apply(leetCode876MiddleNode);
        Assertions.assertTrue(ListNodeVerifyUtil.equals(expectedResult, result));
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(build(new int[]{1, 2, 3, 4, 5}), build(new int[]{3, 4, 5})),
                arguments(build(new int[]{1, 2, 3, 4, 5, 6}), build(new int[]{4, 5, 6}))
        );
    }


}