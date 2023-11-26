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

@DisplayName("三数之和")
public class LeetCode_015_threeSumTest {

    private static final LeetCode_015_threeSum test015ThreeSum = new LeetCode_015_threeSum();

    @DisplayName("原版题目解法")
    @ParameterizedTest
    @MethodSource("generateOriginRightCase")
    public void testOrigin(int[] nums, List<List<Integer>> expectedResults) {
        commonTestOrigin(expectedResults, x -> x.threeSum01(nums));
    }

    @DisplayName("原版题目解法")
    @ParameterizedTest
    @MethodSource("generateOriginRightCase")
    public void testOriginExample(int[] nums, List<List<Integer>> expectedResults) {
        commonTestOrigin(expectedResults, x -> x.threeSumExample(nums));
    }

    private void commonTestOrigin(List<List<Integer>> expectedResults, Function<LeetCode_015_threeSum, List<List<Integer>>> function) {
        expectedResults.forEach(x -> x.sort(Integer::compareTo));

        List<List<Integer>> actResultList = function.apply(test015ThreeSum);

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


    @DisplayName("变版题目解法")
    @ParameterizedTest
    @MethodSource("generateChangeRightCase")
    public void testChange01(int[] nums, int target, int[] expectedResults) {
        commonTestChange(expectedResults, x -> x.threeSumChange01(nums, target));
    }

    @DisplayName("变版题目解法")
    @ParameterizedTest
    @MethodSource("generateChangeRightCase")
    public void testChange02(int[] nums, int target, int[] expectedResults) {
        commonTestChange(expectedResults, x -> x.threeSumChange02(nums, target));
    }

    private void commonTestChange(int[] expectedResults, Function<LeetCode_015_threeSum, int[]> function) {
        int[] actResult1 = function.apply(test015ThreeSum);
        Arrays.sort(expectedResults);
        Arrays.sort(actResult1);
        Assertions.assertEquals(expectedResults.length, actResult1.length);
        for (int i = 0; i < expectedResults.length; i++) {
            Assertions.assertEquals(expectedResults[i], actResult1[i]);
        }
    }

    public static Stream<Arguments> generateOriginRightCase() {
        return Stream.of(
                arguments(new int[]{-1, 0, 1, 2, -1, -4}, List.of(Arrays.asList(-1, -1, 2), Arrays.asList(-1, 0, 1))),
                arguments(new int[]{-1, 0, 1, 2, -4}, List.of(Arrays.asList(-1, 0, 1))),
                arguments(new int[]{0, 0, 0, 0, 0}, List.of(Arrays.asList(0, 0, 0))),
                arguments(new int[]{0, 1, 1}, List.of()),
                arguments(new int[]{0, 0, 0}, List.of(Arrays.asList(0, 0, 0))),
                arguments(new int[]{3, 2, -5}, List.of(Arrays.asList(3, 2, -5)))
        );
    }

    public static Stream<Arguments> generateChangeRightCase() {
        return Stream.of(
                arguments(new int[]{-1, 0, 1, 2, -4}, 0, new int[]{-1, 0, 1}),
                arguments(new int[]{2, 7, 11, 15}, 20, new int[]{2, 7, 11}),
                arguments(new int[]{2, 7, 11, 15}, 28, new int[]{2, 11, 15}),
                arguments(new int[]{2, 7, 11, 15}, 33, new int[]{7, 11, 15}),
                arguments(new int[]{3, 2, 4}, 9, new int[]{3, 2, 4})
        );
    }

}
