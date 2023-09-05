package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("XXXX")
class Test_130_solveTest {
    private final Test_130_solve solve = new Test_130_solve();


    //    @ParameterizedTest
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
                arguments(new int[]{1,8,6,2,5,4,8,3,7}, 49),
                arguments(new int[]{1,1}, 1)
        );
    }
}