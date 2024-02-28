package org.github.fourth.leetcode;

import org.github.fourth.VerifyUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("组合总和")
class LeetCode_039_combinationSumTest {
    private final LeetCode_039_combinationSum leetCode039CombinationSum = new LeetCode_039_combinationSum();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(int[] candidates, int target, List<List<Integer>> expectedResult) {
        List<List<Integer>> actResult = leetCode039CombinationSum.combinationSum01(candidates, target);
        VerifyUtils.assertListInListEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{2, 3, 6, 7}, 7, List.of(List.of(2, 2, 3), List.of(7))),
                arguments(new int[]{2, 3, 5}, 8, List.of(List.of(2, 2, 2, 2), List.of(2, 3, 3), List.of(3, 5))),
                arguments(new int[]{2}, 1, List.of())
        );
    }


}