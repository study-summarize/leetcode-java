package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("和为k的子数组")
public class LeetCode_560_subarraySumTest {

    private static final LeetCode_560_subarraySum leetCode560 = new LeetCode_560_subarraySum();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(int[] nums, int k, int expectedResults) {

        int actResultExample = leetCode560.subarraySumExample(Arrays.copyOf(nums, nums.length), k);
        int actResult = leetCode560.subarraySum(Arrays.copyOf(nums, nums.length), k);

        Assertions.assertEquals(expectedResults, actResult);
        Assertions.assertEquals(expectedResults, actResultExample);

    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{1, 1, 1}, 2, 2),
                arguments(new int[]{1, 2, 3}, 3, 2)
        );
    }
}
