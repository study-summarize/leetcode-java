package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("爬楼梯")
class LeetCode_070_climbStairsTest {

    private final LeetCode_070_climbStairs climbStairs = new LeetCode_070_climbStairs();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(int n, int expectedResult) {
        int actResult01 = climbStairs.climbStairs01(n);
        Assertions.assertEquals(expectedResult, actResult01);
    }
    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test02(int n, int expectedResult) {
        int actResult02 = climbStairs.climbStairs02(n);
        Assertions.assertEquals(expectedResult, actResult02);
    }
    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test03(int n, int expectedResult) {
        int actResult = climbStairs.climbStairs03(n);
        Assertions.assertEquals(expectedResult, actResult);
    }
    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test04(int n, int expectedResult) {
        int actResult = climbStairs.climbStairs04(n);
        Assertions.assertEquals(expectedResult, actResult);
    }

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void testExample(int n, int expectedResult) {
        int actResult = climbStairs.climbStairsExample(n);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(2, 2),
                arguments(3, 3)
        );
    }
}