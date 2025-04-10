package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("组合总和 Ⅳ")
class LeetCode_377_combinationSum4Test {
    private final LeetCode_377_combinationSum4 combinationSum4 = new LeetCode_377_combinationSum4();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(int[] nums, int target, int expectedResult) {
        int actResult = combinationSum4.combinationSum401(nums, target);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{1, 2, 3}, 4, 7),
                arguments(new int[]{9}, 3, 0)
        );
    }
}