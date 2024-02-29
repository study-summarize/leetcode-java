package org.github.fourth.leetcode.lcr;

import org.github.fourth.VerifyUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("LCR 139. 训练计划 I")
class LCR_139_trainingPlanTest {
    private final LCR_139_trainingPlan lcr139TrainingPlan = new LCR_139_trainingPlan();


    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void testExample(int[] actions, int[] expectedResult, int pos) {
        int[] actResult = lcr139TrainingPlan.trainingPlanExample(actions);
        VerifyUtils.assertListEquals(List.of(expectedResult), List.of(actResult));
        for (int i = 0; i <= pos; i++) {
            Assertions.assertEquals(1, actResult[i] % 2);
        }
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{1, 2, 3, 4, 5}, new int[]{1, 5, 3, 4, 2}, 2)
        );
    }


}