package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("岛屿数量")
class LeetCode_200_numIslandsTest {
    private final LeetCode_200_numIslands numIslands = new LeetCode_200_numIslands();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(char[][] grid, int expectedResult) {
        int actResult1 = numIslands.numIslands01(grid);
        Assertions.assertEquals(expectedResult, actResult1);
    }

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void testExample01(char[][] grid, int expectedResult) {
        int actResult1 = numIslands.numIslandsExample01(grid);
        Assertions.assertEquals(expectedResult, actResult1);
    }

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void testExample02(char[][] grid, int expectedResult) {
        int actResult2 = numIslands.numIslandsWithDfsExample(grid);
        Assertions.assertEquals(expectedResult, actResult2);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new char[][]{
                        {'1', '1', '1', '1', '0'},
                        {'1', '1', '0', '1', '0'},
                        {'1', '1', '0', '0', '0'},
                        {'0', '0', '0', '0', '0'}
                }, 1),
                arguments(new char[][]{
                        {'1', '1', '0', '0', '0'},
                        {'1', '1', '0', '0', '0'},
                        {'0', '0', '1', '0', '0'},
                        {'0', '0', '0', '1', '1'}
                }, 3)
        );
    }
}