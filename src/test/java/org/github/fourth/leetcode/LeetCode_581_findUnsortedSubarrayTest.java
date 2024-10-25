package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class LeetCode_581_findUnsortedSubarrayTest {
    private final LeetCode_581_findUnsortedSubarray instance = new LeetCode_581_findUnsortedSubarray();


    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(int[] nums, int expectedResult) {
        int actResult = instance.findUnsortedSubarray01(nums);
        Assertions.assertEquals(expectedResult, actResult);
    }

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test02(int[] nums, int expectedResult) {
        int actResult = instance.findUnsortedSubarray02(nums);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{2, 6, 4, 8, 10, 9, 15}, 5),
                arguments(new int[]{1, 2, 3, 4}, 0),
                arguments(new int[]{}, 0)
        );
    }

}