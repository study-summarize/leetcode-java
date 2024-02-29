package org.github.fourth.leetcode;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


@DisplayName("")
class LeetCode_463_islandPerimeterTest {
    private final LeetCode_463_islandPerimeter testInstance = new LeetCode_463_islandPerimeter();

//    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(int[][] grid, int expected) {
        int actResult = testInstance.islandPerimeter(grid);
        Assertions.assertEquals(expected, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
        );
    }

}