package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("一维数组的动态和")
public class LeetCode_1480_runningSumTest {

    private static final LeetCode_1480_runningSum leetCode1480 = new LeetCode_1480_runningSum();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(int[] nums, int[] expectedResults) {
        commonTest(expectedResults, x -> x.runningSum(nums));
    }
    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void testExample(int[] nums, int[] expectedResults) {
        commonTest(expectedResults, x -> x.runningSumExample(nums));
    }

    private void commonTest(int[] expectedResults, Function<LeetCode_1480_runningSum, int[]> function) {
        int[] actResult = function.apply(leetCode1480);
        Assertions.assertEquals(expectedResults.length, actResult.length);
        for (int i = 0; i < expectedResults.length; i++) {
            Assertions.assertEquals(expectedResults[i], actResult[i]);
        }
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{1, 2, 3, 4}, new int[]{1, 3, 6, 10}),
                arguments(new int[]{1, 1, 1, 1, 1}, new int[]{1, 2, 3, 4, 5}),
                arguments(new int[]{3, 1, 2, 10, 1}, new int[]{3, 4, 6, 16, 17})
        );
    }
}
