package leetcode;

import org.github.fourth.leetcode.LeetCode_746_minCostClimbingStairs;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("XXXX 测试")
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
                arguments(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}, 49),
                arguments(new int[]{1, 1}, 1)
        );
    }
}