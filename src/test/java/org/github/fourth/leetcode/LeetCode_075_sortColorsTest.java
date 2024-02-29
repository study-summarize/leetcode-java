package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("颜色分类")
class LeetCode_075_sortColorsTest {

    private final LeetCode_075_sortColors sortColors = new LeetCode_075_sortColors();

//    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(int[] nums, int[] expectedResult) {
        sortColors.sortColors01(nums);
        Assertions.assertArrayEquals(expectedResult, nums);
    }
    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void testExample(int[] nums, int[] expectedResult) {
        sortColors.sortColorsExample(nums);
        Assertions.assertArrayEquals(expectedResult, nums);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{2, 0, 2, 1, 1, 0}, new int[]{0, 0, 1, 1, 2, 2}),
                arguments(new int[]{2, 0, 1}, new int[]{0, 1, 2})
        );
    }
}