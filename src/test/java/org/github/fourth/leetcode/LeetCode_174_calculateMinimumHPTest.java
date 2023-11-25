package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("地下城游戏")
class LeetCode_174_calculateMinimumHPTest {
    private final LeetCode_174_calculateMinimumHP calculateMinimumHP = new LeetCode_174_calculateMinimumHP();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(int[][] dungeon, int expectedResult) {
        int actResult = calculateMinimumHP.calculateMinimumHP(dungeon);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[][]{
                        {-2, -3, 3},
                        {-5, -10, 1},
                        {10, 30, -5}
                }, 7),
                arguments(new int[][]{{0}}, 1)
        );
    }
}