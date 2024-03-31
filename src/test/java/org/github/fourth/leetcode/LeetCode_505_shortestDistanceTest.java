package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("505. 迷宫 II")
class LeetCode_505_shortestDistanceTest {
    private final LeetCode_505_shortestDistance shortestDistance = new LeetCode_505_shortestDistance();


//    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(int[][] maze, int[] start, int[] destination, int expectedResult) {
        int actResult = shortestDistance.shortestDistance01(maze, start, destination);
        Assertions.assertEquals(expectedResult, actResult);
    }

//    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void testExample(int[][] maze, int[] start, int[] destination, int expectedResult) {
        int actResult = shortestDistance.shortestDistanceExample(maze, start, destination);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[][]{
                        {0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0},
                        {0, 0, 0, 1, 0},
                        {1, 1, 0, 1, 1},
                        {0, 0, 0, 0, 0}
                }, new int[]{0, 4}, new int[]{4, 4}, 12),
                arguments(new int[][]{
                        {0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0},
                        {0, 0, 0, 1, 0},
                        {1, 1, 0, 1, 1},
                        {0, 0, 0, 0, 0}
                }, new int[]{0, 4}, new int[]{3, 2}, -1),
                arguments(new int[][]{
                                {0, 0, 0, 0, 0},
                                {1, 1, 0, 0, 1},
                                {0, 0, 0, 0, 0},
                                {0, 1, 0, 0, 1},
                                {0, 1, 0, 0, 0}
                        }, new int[]{4, 3}, new int[]{0, 1}, -1
                )
        );
    }
}