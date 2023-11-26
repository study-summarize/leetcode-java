package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("四数之和")
public class LeetCode_018_fourSumTest {

    private static final LeetCode_018_fourSum test018FourSum = new LeetCode_018_fourSum();

    @ParameterizedTest
    @MethodSource("generateOriginRightCase")
    public void test(int[] nums, int target, List<List<Integer>> expectedResults) {
        commonTest(expectedResults, x -> x.fourSum(nums, target));
    }

    @ParameterizedTest
    @MethodSource("generateOriginRightCase")
    public void testExample(int[] nums, int target, List<List<Integer>> expectedResults) {
        commonTest(expectedResults, x -> x.fourSumExample(nums, target));
    }

    private void commonTest(List<List<Integer>> expectedResults, Function<LeetCode_018_fourSum, List<List<Integer>>> function) {
        expectedResults.forEach(x -> x.sort(Integer::compareTo));

        List<List<Integer>> actResultList = function.apply(test018FourSum);
        Assertions.assertEquals(expectedResults.size(), actResultList.size());
        actResultList.forEach(x -> x.sort(Integer::compareTo));

        for (int i = 0; i < expectedResults.size(); i++) {
            Assertions.assertEquals(expectedResults.get(i).size(), actResultList.get(i).size());
        }

        for (int i = 0; i < expectedResults.size(); i++) {
            for (int j = 0; j < expectedResults.get(i).size(); j++) {
                Assertions.assertEquals(expectedResults.get(i).get(j), actResultList.get(i).get(j));
            }
        }
    }

    public static Stream<Arguments> generateOriginRightCase() {
        return Stream.of(
                arguments(new int[]{2, 2, 2, 2, 2}, 8, List.of(Arrays.asList(2, 2, 2, 2))),
                arguments(new int[]{-4, -1, -1, 0, 1, 2}, -1, List.of(Arrays.asList(-4, 0, 1, 2), Arrays.asList(-1, -1, 0, 1))),
                // note: 这里溢出的题目好烦啊
                arguments(new int[]{1000000000, 1000000000, 1000000000, 1000000000}, -294967296, List.of()),

                arguments(new int[]{-1, 0, 1, 2, -1, -4, 0}, 0, List.of(Arrays.asList(-1, -1, 2, 0), Arrays.asList(-1, 0, 1, 0))),
                arguments(new int[]{-1, 0, 1, 2, -4, 0}, 0, List.of(Arrays.asList(-1, 0, 1, 0))),
                arguments(new int[]{0, 0, 0, 0, 0, 0}, 0, List.of(Arrays.asList(0, 0, 0, 0))),
                arguments(new int[]{0, 1, 1, 0}, 0, List.of()),
                arguments(new int[]{0, 0, 0, 0}, 0, List.of(Arrays.asList(0, 0, 0, 0))),
                arguments(new int[]{3, 2, -5, 0}, 0, List.of(Arrays.asList(3, 2, -5, 0)))
        );
    }

}
