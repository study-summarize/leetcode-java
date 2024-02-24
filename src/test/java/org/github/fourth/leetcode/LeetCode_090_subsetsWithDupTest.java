package org.github.fourth.leetcode;

import org.github.fourth.VerifyUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("子集 II")
class LeetCode_090_subsetsWithDupTest {
    private final LeetCode_090_subsetsWithDup leetCode090SubsetsWithDup = new LeetCode_090_subsetsWithDup();


    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(int[] nums, List<List<Integer>> expectedResult) {
        List<List<Integer>> actResult = leetCode090SubsetsWithDup.subsetsWithDup(nums);
        VerifyUtils.assertListInListEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{1, 2, 2}, List.of(List.of(), List.of(1), List.of(1, 2), List.of(1, 2, 2), List.of(2), List.of(2, 2))),
                arguments(new int[]{0}, List.of(List.of(), List.of(0)))
        );
    }

}