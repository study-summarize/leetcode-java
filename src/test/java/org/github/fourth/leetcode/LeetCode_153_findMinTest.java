package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("寻找旋转排序数组中的最小值")
public class LeetCode_153_findMinTest {

    private final LeetCode_153_findMin leetCode153FindMin = new LeetCode_153_findMin();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(int[] nums, int expectedResult) {
        int actResult = leetCode153FindMin.findMin(Arrays.copyOf(nums, nums.length));
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{3, 4, 5, 1, 2}, 1),
                arguments(new int[]{4, 5, 6, 7, 0, 1, 2}, 0),
                arguments(new int[]{11, 13, 15, 17}, 11)
        );
    }

}
