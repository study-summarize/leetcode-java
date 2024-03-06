package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.Function;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("被围绕的区域")
class LeetCode_130_solveTest {

    private final LeetCode_130_solve solve = new LeetCode_130_solve();
    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(char[][] board, char[][] expectedResult) {
        commonTest(expectedResult, x -> {
            solve.solve01(board);
            return board;
        });
    }

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void testExample01(char[][] board, char[][] expectedResult) {
        commonTest(expectedResult, x -> {
            solve.solveExample01(board);
            return board;
        });
    }

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void testExample02(char[][] board, char[][] expectedResult) {
        commonTest(expectedResult, x -> {
            solve.solveWithDfsExample02(board);
            return board;
        });
    }

    private void commonTest(char[][] expectedResult, Function<LeetCode_130_solve, char[][]> function) {
        char[][] actResult = function.apply(solve);
        Assertions.assertArrayEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new char[][]{
                                new char[]{'X', 'X', 'X', 'X'},
                                new char[]{'X', 'O', 'O', 'X'},
                                new char[]{'X', 'X', 'O', 'X'},
                                new char[]{'X', 'O', 'X', 'X'}},
                        new char[][]{
                                new char[]{'X', 'X', 'X', 'X'},
                                new char[]{'X', 'X', 'X', 'X'},
                                new char[]{'X', 'X', 'X', 'X'},
                                new char[]{'X', 'O', 'X', 'X'}
                        }
                ),
                arguments(new char[][]{
                                new char[]{'X'}
                        }, new char[][]{
                                new char[]{'X'}
                        }
                )
        );
    }
}