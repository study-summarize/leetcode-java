package leetcode;

import org.github.fourth.leetcode.LeetCode_256_minCost;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("256. 粉刷房子")
class LeetCode_256_minCostTest {
    private final LeetCode_256_minCost minCost = new LeetCode_256_minCost();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(int[][] costs, int expectedResult) {
        int actResult = minCost.minCost(costs);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[][]{
                        {17, 2, 17},
                        {16, 16, 5},
                        {14, 3, 19}
                }, 10),
                arguments(new int[][]{
                        {7, 6, 2}
                }, 2)
        );
    }
}