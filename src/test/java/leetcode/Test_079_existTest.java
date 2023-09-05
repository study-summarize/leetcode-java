package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("XXX测试")
class Test_079_existTest {

    private final Test_079_exist exist = new Test_079_exist();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(char[][] board, String word, boolean expectedResult) {
        boolean actResult = exist.exist(board, word);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new char[][]{
                        new char[]{'A', 'B', 'C', 'E'},
                        new char[]{'S', 'F', 'C', 'S'},
                        new char[]{'A', 'D', 'E', 'E'},
                }, "ABCCED", true),
                arguments(new char[][]{
                        new char[]{'A', 'B', 'C', 'E'},
                        new char[]{'S', 'F', 'C', 'S'},
                        new char[]{'A', 'D', 'E', 'E'},
                }, "ABCB", false)
        );
    }
}