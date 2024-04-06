package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("删除并获得点数")
class LeetCode_740_deleteAndEarnTest {
    private final LeetCode_740_deleteAndEarn deleteAndEarn = new LeetCode_740_deleteAndEarn();


    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(int[] nums, int expectedResult) {
        int actResult = deleteAndEarn.deleteAndEarn01(nums);
        Assertions.assertEquals(expectedResult, actResult);
    }
    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test02(int[] nums, int expectedResult) {
        int actResult = deleteAndEarn.deleteAndEarn02(nums);
        Assertions.assertEquals(expectedResult, actResult);
    }
    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test03(int[] nums, int expectedResult) {
        int actResult = deleteAndEarn.deleteAndEarn03(nums);
        Assertions.assertEquals(expectedResult, actResult);
    }
    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void testExample(int[] nums, int expectedResult) {
        int actResult = deleteAndEarn.deleteAndEarnExample(nums);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{3, 4, 2}, 6),
                arguments(new int[]{2, 2, 3, 3, 3, 4}, 9)
        );
    }
}