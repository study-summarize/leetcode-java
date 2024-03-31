package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("省份数量")
class LeetCode_547_findCircleNumTest {
    private final LeetCode_547_findCircleNum findCircleNum = new LeetCode_547_findCircleNum();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(int[][] isConnected, int expectedResult) {
        int actResult = findCircleNum.findCircleNum01(isConnected);
        Assertions.assertEquals(expectedResult, actResult);
    }
    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test02(int[][] isConnected, int expectedResult) {
        int actResult = findCircleNum.findCircleNum02(isConnected);
        Assertions.assertEquals(expectedResult, actResult);
    }

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void testExample(int[][] isConnected, int expectedResult) {
        int actResult = findCircleNum.findCircleNumExample(isConnected);
        Assertions.assertEquals(expectedResult, actResult);

        int actResult2 = findCircleNum.findCircleNumWithDfsExample(isConnected);
        Assertions.assertEquals(expectedResult, actResult2);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[][]{
                        {1, 1, 0},
                        {1, 1, 0},
                        {0, 0, 1}
                }, 2),
                arguments(new int[][]{
                        {1, 0, 0},
                        {0, 1, 0},
                        {0, 0, 1}
                }, 3)
        );
    }
}