package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


@DisplayName("XXX测试")
class Test_062_uniquePathsTest {

    private final Test_062_uniquePaths uniquePaths = new Test_062_uniquePaths();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(int m, int n, int expectedResult) {

        int actResult = uniquePaths.uniquePaths(m, n);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
        );
    }
}