package leetcode;

import org.github.fourth.leetcode.LeetCode_130_solve;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("被围绕的区域 测试")
class LeetCode_130_solveTest {

    private final LeetCode_130_solve solve = new LeetCode_130_solve();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(char[][] board, char[][] expectedResult) {
        char[][] board1 = board.clone();
        solve.solve(board1);
        Assertions.assertArrayEquals(expectedResult, board1);

        char[][] board2 = board.clone();
        solve.solveWithDfs(board2);
        Assertions.assertArrayEquals(expectedResult, board2);
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