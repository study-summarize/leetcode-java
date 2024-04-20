package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("最长递增子序列的个数")
class LeetCode_673_findNumberOfLISTest {
    private final LeetCode_673_findNumberOfLIS findNumberOfLIS = new LeetCode_673_findNumberOfLIS();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(int[] nums, int expectedResult) {
        int actResult = findNumberOfLIS.findNumberOfLIS01(nums);
        Assertions.assertEquals(expectedResult, actResult);
    }

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test02(int[] nums, int expectedResult) {
        int actResult = findNumberOfLIS.findNumberOfLIS02(nums);
        Assertions.assertEquals(expectedResult, actResult);
    }

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test03(int[] nums, int expectedResult) {
        int actResult = findNumberOfLIS.findNumberOfLIS03(nums);
        Assertions.assertEquals(expectedResult, actResult);
    }

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void testExample(int[] nums, int expectedResult) {
        int actResult = findNumberOfLIS.findNumberOfLISExample(nums);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{1, 2, 4, 3, 5, 4, 7, 2}, 3),
                arguments(new int[]{1, 3, 5, 4, 7}, 2),
                arguments(new int[]{2, 2, 2, 2, 2}, 5)
        );
    }
}