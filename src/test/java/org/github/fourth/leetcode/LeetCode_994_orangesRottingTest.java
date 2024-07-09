package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("994. 腐烂的橘子")
class LeetCode_994_orangesRottingTest {
    private final LeetCode_994_orangesRotting instance = new LeetCode_994_orangesRotting();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(int[][] grid, int expectedResult) {
        int actResult = instance.orangesRotting(grid);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(
                        new int[][]{
                                {2, 1, 1},
                                {1, 1, 0},
                                {0, 1, 1}
                        }, 4
                ),
                arguments(
                        new int[][]{
                                {2, 1, 1},
                                {0, 1, 1},
                                {1, 0, 1}
                        }, -1
                )
        );
    }


}