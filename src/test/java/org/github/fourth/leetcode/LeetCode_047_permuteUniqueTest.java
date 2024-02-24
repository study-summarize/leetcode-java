package org.github.fourth.leetcode;

import org.github.fourth.VerifyUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("全排列 II")
class LeetCode_047_permuteUniqueTest {
    private final LeetCode_047_permuteUnique leetCode047PermuteUnique = new LeetCode_047_permuteUnique();


    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(int[] nums, List<List<Integer>> expectedResult) {
        List<List<Integer>> actResult = leetCode047PermuteUnique.permuteUnique(nums);
        VerifyUtils.assertListInListEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{1, 1, 2}, List.of(List.of(1, 1, 2), List.of(1, 2, 1), List.of(2, 1, 1))),
                arguments(new int[]{1, 2, 3}, List.of(List.of(1, 2, 3), List.of(1, 3, 2), List.of(2, 1, 3), List.of(2, 3, 1), List.of(3, 1, 2), List.of(3, 2, 1)))
        );
    }


}