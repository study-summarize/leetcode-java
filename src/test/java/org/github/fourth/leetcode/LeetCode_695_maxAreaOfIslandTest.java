package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("岛屿的最大面积")
class LeetCode_695_maxAreaOfIslandTest {

    private final LeetCode_695_maxAreaOfIsland maxAreaOfIsland = new LeetCode_695_maxAreaOfIsland();

//    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(int[][] grid, int expectedResult) {
        int actResult = maxAreaOfIsland.maxAreaOfIsland01(grid);
        Assertions.assertEquals(expectedResult, actResult);
    }
    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void testExample(int[][] grid, int expectedResult) {
        int actResult = maxAreaOfIsland.maxAreaOfIslandExample(grid);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[][]{
                        {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                        {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                        {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
                }, 6),
                arguments(new int[][]{
                        {0, 0, 0, 0, 0, 0, 0, 0}
                }, 0)
        );
    }
}