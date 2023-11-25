package leetcode;

import org.github.fourth.leetcode.LeetCode_746_minCostClimbingStairs;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("使用最小花费爬楼梯")
class LeetCode_746_minCostClimbingStairsTest {
    private final LeetCode_746_minCostClimbingStairs minCostClimbingStairs = new LeetCode_746_minCostClimbingStairs();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(int[] cost, int expectedResult) {
        int actResult = minCostClimbingStairs.minCostClimbingStairs(cost);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{10, 15, 20}, 15),
                arguments(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}, 6)
        );
    }
}