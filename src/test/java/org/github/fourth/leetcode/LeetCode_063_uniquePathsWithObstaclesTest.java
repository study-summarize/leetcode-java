package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;


@DisplayName("不同路径 II")
class LeetCode_063_uniquePathsWithObstaclesTest {

    private final LeetCode_063_uniquePathsWithObstacles uniquePathsWithObstacles = new LeetCode_063_uniquePathsWithObstacles();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(int[][] obstacleGrid, int expectedResult) {

        int actResult = uniquePathsWithObstacles.uniquePathsWithObstacles(obstacleGrid);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[][]{
                        {0, 0, 0},
                        {0, 1, 0},
                        {0, 0, 0}
                }, 5),
                arguments(new int[][]{
                        {0, 1},
                        {0, 0}
                }, 1)
        );
    }
}