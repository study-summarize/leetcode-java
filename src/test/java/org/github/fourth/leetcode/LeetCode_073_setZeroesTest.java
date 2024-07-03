package org.github.fourth.leetcode;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("73. 矩阵置零")
class LeetCode_073_setZeroesTest {
    private final LeetCode_073_setZeroes instance = new LeetCode_073_setZeroes();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(int[][] matrix, int[][] expectedResult) {
        instance.setZeroes(matrix);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(
                        new int[][]{
                                {1, 1, 1},
                                {1, 0, 1},
                                {1, 1, 1}},
                        new int[][]{
                                {1, 0, 1},
                                {0, 0, 0},
                                {1, 0, 1}}),
                arguments(
                        new int[][]{
                                {0, 1, 2, 0},
                                {3, 4, 5, 2},
                                {1, 3, 1, 5}},
                        new int[][]{
                                {0, 0, 0, 0},
                                {0, 4, 5, 0},
                                {0, 3, 1, 0}})
        );
    }
}