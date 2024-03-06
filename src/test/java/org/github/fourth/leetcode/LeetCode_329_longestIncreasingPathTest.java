package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("矩阵中的最长递增路径")
class LeetCode_329_longestIncreasingPathTest {
    private final LeetCode_329_longestIncreasingPath longestIncreasingPath = new LeetCode_329_longestIncreasingPath();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(int[][] matrix, int expectedResult) {
        int actResult = longestIncreasingPath.longestIncreasingPath01(matrix);
        Assertions.assertEquals(expectedResult, actResult);
    }
    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void testExample(int[][] matrix, int expectedResult) {
        int actResult = longestIncreasingPath.longestIncreasingPathExample(matrix);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[][]{
                        {9, 9, 4},
                        {6, 6, 8},
                        {2, 1, 1}
                }, 4),
                arguments(new int[][]{
                        {3, 4, 5},
                        {3, 2, 6},
                        {2, 2, 1}
                }, 4),
                arguments(new int[][]{
                        {1}
                }, 1)
        );
    }
}