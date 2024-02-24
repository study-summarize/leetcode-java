package org.github.fourth.leetcode;

import org.github.fourth.VerifyUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("子集")
class LeetCode_078_subsetsTest {
    private final LeetCode_078_subsets leetCode078Subsets = new LeetCode_078_subsets();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(int[] nums, List<List<Integer>> expectedResult) {
        List<List<Integer>> actResult = leetCode078Subsets.subsets(nums);
        VerifyUtils.assertListInListEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{1, 2, 3}, List.of(
                        List.of(),
                        List.of(1), List.of(2),
                        List.of(1, 2), List.of(3),
                        List.of(1, 3), List.of(2, 3), List.of(1, 2, 3))
                ),
                arguments(new int[]{0}, List.of(List.of(), List.of(0)))
        );
    }


}