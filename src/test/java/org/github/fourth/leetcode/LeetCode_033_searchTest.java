package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("搜索旋转排序数组")
public class LeetCode_033_searchTest {

    private final LeetCode_033_search leetCode033Search = new LeetCode_033_search();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(int[] nums, int target, int expectedResult) {
        int actResult = leetCode033Search.search(Arrays.copyOf(nums, nums.length), target);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{4, 5, 6, 7, 0, 1, 2}, 0, 4),
                arguments(new int[]{4, 5, 6, 7, 0, 1, 2}, 3, -1),
                arguments(new int[]{1}, 0, -1)
        );
    }
}
