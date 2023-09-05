package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("XXX测试")
class Test_079_existTest {

    private final Test_079_exist exist = new Test_079_exist();
    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(char[][] board, String word, boolean expectedResult) {
        boolean actResult = exist.exist(board, word);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
        );
    }
}