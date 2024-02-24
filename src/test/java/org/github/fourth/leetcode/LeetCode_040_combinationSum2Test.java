package org.github.fourth.leetcode;

import org.github.fourth.VerifyUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("组合总和 II")
class LeetCode_040_combinationSum2Test {
    private final LeetCode_040_combinationSum2 leetCode040CombinationSum2 = new LeetCode_040_combinationSum2();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(int[] candidates, int target, List<List<Integer>> expectedResult) {
        List<List<Integer>> actResult = leetCode040CombinationSum2.combinationSum2(candidates, target);
        VerifyUtils.assertListInListEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{10, 1, 2, 7, 6, 1, 5}, 0, List.of(List.of(1, 1, 6), List.of(1, 2, 5), List.of(1, 7), List.of(2, 6))),
                arguments(new int[]{2, 5, 2, 1, 2}, 5, List.of(List.of(1, 2, 2), List.of(5)))
        );
    }

}