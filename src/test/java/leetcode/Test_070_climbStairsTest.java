package leetcode;

import org.github.fourth.leetcode.LeetCode_070_climbStairs;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("XXX测试")
class Test_070_climbStairsTest {

    private final LeetCode_070_climbStairs climbStairs = new LeetCode_070_climbStairs();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(int n, int expectedResult) {
        int actResult = climbStairs.climbStairs(n);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(2, 2),
                arguments(3, 3)
        );
    }
}