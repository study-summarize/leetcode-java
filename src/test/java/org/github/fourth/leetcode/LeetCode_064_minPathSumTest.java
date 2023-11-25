package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("最小路径和")
class LeetCode_064_minPathSumTest {

    private final LeetCode_064_minPathSum minPathSum = new LeetCode_064_minPathSum();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(int[][] grid, int expectedResult) {

        int actResult = minPathSum.minPathSum(grid);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[][]{
                        {1, 3, 1},
                        {1, 5, 1},
                        {4, 2, 1}
                }, 7),
                arguments(new int[][]{
                        {1, 2, 3},
                        {4, 5, 6}
                }, 12)
        );
    }
}