package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("滑动窗口最大值")
class LeetCode_239_maxSlidingWindowTest {
    private final LeetCode_239_maxSlidingWindow leetCode239MaxSlidingWindow = new LeetCode_239_maxSlidingWindow();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(int[] nums, int k, int[] expectedResult) {
        int[] actResult = leetCode239MaxSlidingWindow.maxSlidingWindow01(nums, k);
        Assertions.assertArrayEquals(expectedResult, actResult);
    }

//    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test02(int[] nums, int k, int[] expectedResult) {
        int[] actResult = leetCode239MaxSlidingWindow.maxSlidingWindow02(nums, k);
        Assertions.assertArrayEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3, new int[]{3, 3, 5, 5, 6, 7}),
                arguments(new int[]{1}, 1, new int[]{1})
        );
    }


}