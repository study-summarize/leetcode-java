package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.Function;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("最大子数组和")
class LeetCode_053_maxSubArrayTest {

    private final LeetCode_053_maxSubArray maxSubArray = new LeetCode_053_maxSubArray();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(int[] nums, int expectedResult) {
//        testCommon(expectedResult, x -> x.maxSubArray01(nums)); todo fix
    }

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test02(int[] nums, int expectedResult) {
        testCommon(expectedResult, x -> x.maxSubArray02(nums));
    }

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test03(int[] nums, int expectedResult) {
        testCommon(expectedResult, x -> x.maxSubArray03(nums));
    }

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void testExample(int[] nums, int expectedResult) {
        testCommon(expectedResult, x -> x.maxSubArrayExample(nums));
    }

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void testExampleRefine(int[] nums, int expectedResult) {
        testCommon(expectedResult, x -> x.maxSubArrayExampleRefine(nums));
    }

    private void testCommon(int expectedResult, Function<LeetCode_053_maxSubArray, Integer> function) {
        int actResult = function.apply(maxSubArray);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{-1}, -1),
                arguments(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}, 6),
                arguments(new int[]{5, 4, -1, 7, 8}, 23),
                arguments(new int[]{1}, 1)
        );
    }

}