package org.github.fourth.leetcode.lcr;

import org.github.fourth.leetcode.common.ListNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.github.fourth.leetcode.common.ListNode.build;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("得到链表的倒数第N个节点")
class LCR_140_trainingPlanTest {
    private final LCR_140_trainingPlan lcr140TrainingPlan = new LCR_140_trainingPlan();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(ListNode head, int cnt, int expectedResult) {
        ListNode actResult = lcr140TrainingPlan.trainingPlan(head, cnt);
        // todo: 如何验证？？？
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(build(new int[]{2, 4, 7, 8}), 1, 8)
        );
    }
}
