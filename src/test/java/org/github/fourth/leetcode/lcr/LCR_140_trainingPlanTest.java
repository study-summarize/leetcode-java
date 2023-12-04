package org.github.fourth.leetcode.lcr;

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

@DisplayName("得到链表的倒数第N个节点")
class LCR_140_trainingPlanTest {
    private final LCR_140_trainingPlan lcr140TrainingPlan = new LCR_140_trainingPlan();

    @DisplayName("暴力方法")
    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(ListNode head, int cnt, ListNode expectedResult) {
        ListNode actResult = lcr140TrainingPlan.trainingPlan(head, cnt);
        Assertions.assertTrue(ListNodeVerifyUtil.equals(actResult, expectedResult));
    }


    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(build(new int[]{2, 4, 7, 8}), 1, build(8))
        );
    }
}
