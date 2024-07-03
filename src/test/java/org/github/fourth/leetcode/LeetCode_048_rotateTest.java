package org.github.fourth.leetcode;


import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class LeetCode_048_rotateTest {
    private final LeetCode_048_rotate instance = new LeetCode_048_rotate();


    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(int[][] matrix, int[][] expectedResult) {
        instance.rotate(matrix);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(
                        new int[][]{
                                {1, 2, 3},
                                {4, 5, 6},
                                {7, 8, 9}},
                        new int[][]{
                                {7, 4, 1},
                                {8, 5, 2},
                                {9, 6, 3}
                        }
                ),
                arguments(
                        new int[][]{
                                {5, 1, 9, 11},
                                {2, 4, 8, 10},
                                {13, 3, 6, 7},
                                {15, 14, 12, 16}
                        },
                        new int[][]{
                                {15, 13, 2, 5},
                                {14, 3, 4, 1},
                                {12, 6, 8, 9},
                                {16, 7, 10, 11}
                        }
                ));
    }

}