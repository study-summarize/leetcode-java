package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("较小的三数之和")
class LeetCode_259_threeSumSmallerTest {
    private final LeetCode_259_threeSumSmaller threeSumSmaller = new LeetCode_259_threeSumSmaller();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(int[] nums, int target, int expectedResult) {
        int actResult = threeSumSmaller.threeSumSmaller(nums, target);
        Assertions.assertEquals(expectedResult, actResult);
    }

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(int[] nums, int target, int expectedResult) {
        int actResult = threeSumSmaller.threeSumSmallerExample(nums, target);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{-2, 0, 1, 3}, 2, 2),
                arguments(new int[0], 0, 0),
                arguments(new int[]{0}, 0, 0)
        );
    }
}