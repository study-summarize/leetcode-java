package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("在排序数组中查找元素的第一个和最后一个位置")
public class LeetCode_034_searchRangeTest {
    private final LeetCode_034_searchRange leetCode034SearchRange = new LeetCode_034_searchRange();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(int[] nums, int target, int[] expectedResult) {
        int[] actResult = leetCode034SearchRange.searchRange(Arrays.copyOf(nums, nums.length), target);
        Assertions.assertArrayEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{5, 7, 7, 8, 8, 10}, 8, new int[]{3, 4}),
                arguments(new int[]{5, 7, 7, 8, 8, 10}, 6, new int[]{-1, -1}),
                arguments(new int[0], 0, new int[]{-1, -1})
        );
    }
}
