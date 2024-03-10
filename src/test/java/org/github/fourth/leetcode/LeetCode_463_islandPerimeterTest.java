package org.github.fourth.leetcode;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


@DisplayName("岛屿的周长")
class LeetCode_463_islandPerimeterTest {
    private final LeetCode_463_islandPerimeter testInstance = new LeetCode_463_islandPerimeter();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(int[][] grid, int expected) {
        int actResult = testInstance.islandPerimeter01(grid);
        Assertions.assertEquals(expected, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                Arguments.arguments(new int[][]{
                        new int[]{0, 1, 0, 0},
                        new int[]{1, 1, 1, 0},
                        new int[]{0, 1, 0, 0},
                        new int[]{1, 1, 0, 0}
                }, 16),
                Arguments.arguments(new int[][]{
                        new int[]{1}
                }, 4),
                Arguments.arguments(new int[][]{
                        new int[]{1, 0}
                }, 4)
        );
    }

}