package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("长度最小的子数组")
class LeetCode_209_minSubArrayLenTest {
    private final LeetCode_209_minSubArrayLen minSubArrayLen = new LeetCode_209_minSubArrayLen();


    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(int target, int[] nums, int expectedResult) {
        int actResult = minSubArrayLen.minSubArrayLen01(target, nums);
        Assertions.assertEquals(expectedResult, actResult);
    }

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void testExample(int target, int[] nums, int expectedResult) {
        int actResult = minSubArrayLen.minSubArrayLenExample(target, nums);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(7, new int[]{2, 3, 1, 2, 4, 3}, 2),
                arguments(4, new int[]{1, 4, 4}, 1),
                arguments(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}, 0)
        );
    }
}