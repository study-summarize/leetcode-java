package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("小于 K 的两数之和")
class LeetCode_1099_twoSumLessThanKTest {
    private final LeetCode_1099_twoSumLessThanK test1099TwoSumLessThanK = new LeetCode_1099_twoSumLessThanK();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(int[] nums, int k, int expectedResult) {
        int actResult = test1099TwoSumLessThanK.twoSumLessThanK(nums, k);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{34, 23, 1, 24, 75, 33, 54, 8}, 60, 58),
                arguments(new int[]{10, 20, 30}, 15, -1)
        );
    }
}