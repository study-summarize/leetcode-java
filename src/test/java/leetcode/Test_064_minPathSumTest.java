package leetcode;

import org.github.fourth.leetcode.LeetCode_064_minPathSum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("XXX测试")
class Test_064_minPathSumTest {

    private final LeetCode_064_minPathSum minPathSum = new LeetCode_064_minPathSum();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(int[][] grid, int expectedResult) {

        int actResult = minPathSum.minPathSum(grid);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
        );
    }
}