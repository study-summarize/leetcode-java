package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("两数之和 II - 输入有序数组")
class LeetCode_167_twoSumTest {
    private final LeetCode_167_twoSum twoSum = new LeetCode_167_twoSum();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(int[] numbers, int target, int[] expectedResult) {
        int[] actResult = twoSum.twoSum(numbers, target);
        Assertions.assertArrayEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{2, 7, 11, 15}, 9, new int[]{1, 2}),
                arguments(new int[]{2, 3, 4}, 6, new int[]{1, 3}),
                arguments(new int[]{-1, 0}, -1, new int[]{1, 2})
        );
    }
}