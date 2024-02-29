package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("最大正方形")
class LeetCode_221_maximalSquareTest {
    private final LeetCode_221_maximalSquare maximalSquare = new LeetCode_221_maximalSquare();


    //        @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(char[][] matrix, int expectedResult) {
        int actResult = maximalSquare.maximalSquare01(matrix);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new char[][]{
                        {'1', '0', '1', '0', '0'},
                        {'1', '0', '1', '1', '1'},
                        {'1', '1', '1', '1', '1'},
                        {'1', '0', '0', '1', '0'}
                }, 4),
                arguments(new char[][]{
                        {'0', '1'},
                        {'1', '0'}
                }, 1),
                arguments(new char[][]{
                        {'0'}
                }, 0)
        );
    }
}