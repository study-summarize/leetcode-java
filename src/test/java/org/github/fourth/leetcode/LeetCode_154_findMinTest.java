package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("寻找旋转排序数组中的最小值 II")
public class LeetCode_154_findMinTest {
    private final LeetCode_154_findMin leetCode154FindMin = new LeetCode_154_findMin();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(int[] nums, int expectedResult) {
        int actResult = leetCode154FindMin.findMin(Arrays.copyOf(nums, nums.length));
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{1, 3, 5}, 1),
                arguments(new int[]{2, 2, 2, 0, 1}, 0)
        );
    }

}
