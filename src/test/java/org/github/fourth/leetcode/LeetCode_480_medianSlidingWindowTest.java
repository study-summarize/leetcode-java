package org.github.fourth.leetcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("滑动窗口中位数")
class LeetCode_480_medianSlidingWindowTest {
    private final LeetCode_480_medianSlidingWindow leetCode480MedianSlidingWindow = new LeetCode_480_medianSlidingWindow();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(int[] nums, int k, double[] expectedResult) {
        double[] actResult = leetCode480MedianSlidingWindow.medianSlidingWindow(nums, k);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3, new double[]{1, -1, -1, 3, 5, 6})
        );
    }

}