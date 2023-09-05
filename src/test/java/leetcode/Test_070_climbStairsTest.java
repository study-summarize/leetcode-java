package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("XXX测试")
class Test_070_climbStairsTest {

    private final Test_070_climbStairs climbStairs = new Test_070_climbStairs();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(int n, int expectedResult) {
        int actResult = climbStairs.climbStairs(n);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
        );
    }
}