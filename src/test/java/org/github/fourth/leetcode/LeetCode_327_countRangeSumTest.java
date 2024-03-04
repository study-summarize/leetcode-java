package org.github.fourth.leetcode;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("区间和的个数")
class LeetCode_327_countRangeSumTest {
    private final LeetCode_327_countRangeSum testInstance = new LeetCode_327_countRangeSum();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(int[] nums, int lower, int upper, int expectedResult) {
        int actResult = testInstance.countRangeSum01(nums, lower, upper);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{-2, 5, -1}, -2, 2, 3),
                arguments(new int[]{0}, 0, 0, 1)
        );
    }
}