package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("搜索插入位置")
public class LeetCode_035_searchInsertTest {

    private final LeetCode_035_searchInsert leetCode035SearchInsert = new LeetCode_035_searchInsert();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(int[] nums, int target, int expectedResult) {
        int actResult = leetCode035SearchInsert.searchInsert(Arrays.copyOf(nums, nums.length), target);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{1, 3, 5, 6}, 5, 2),
                arguments(new int[]{1, 3, 5, 6}, 2, 1),
                arguments(new int[]{1, 3, 5, 6}, 0, 0),
                arguments(new int[]{1, 3, 5, 6}, 7, 4)
        );
    }

}
