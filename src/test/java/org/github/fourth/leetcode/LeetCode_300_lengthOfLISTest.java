package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("最长递增子序列")
class LeetCode_300_lengthOfLISTest {
    private final LeetCode_300_lengthOfLIS lengthOfLIS = new LeetCode_300_lengthOfLIS();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(int[] nums, int expectedResult) {
        int actResult = lengthOfLIS.lengthOfLIS01(nums);
        Assertions.assertEquals(expectedResult, actResult);
    }

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test02(int[] nums, int expectedResult) {
        int actResult = lengthOfLIS.lengthOfLIS02(nums);
        Assertions.assertEquals(expectedResult, actResult);
    }

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test03(int[] nums, int expectedResult) {
        int actResult = lengthOfLIS.lengthOfLIS03(nums);
        Assertions.assertEquals(expectedResult, actResult);
    }

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void testExample(int[] nums, int expectedResult) {
        int actResult = lengthOfLIS.lengthOfLISExample(nums);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{4, 10, 4, 3, 8, 9}, 3), // todo fix
                arguments(new int[]{10, 9, 2, 5, 3, 7, 101, 18}, 4),
                arguments(new int[]{0, 1, 0, 3, 2, 3}, 4),
                arguments(new int[]{7, 7, 7, 7, 7, 7, 7}, 1)
        );
    }
}