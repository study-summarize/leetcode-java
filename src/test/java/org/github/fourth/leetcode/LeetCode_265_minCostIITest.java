package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("265. 粉刷房子 II")
class LeetCode_265_minCostIITest {
    private final LeetCode_265_minCostII minCostII = new LeetCode_265_minCostII();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(int[][] costs, int expectedResult) {
        int actResult1 = minCostII.minCostII(costs);
        Assertions.assertEquals(expectedResult, actResult1);
    }

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void testRefine(int[][] costs, int expectedResult) {
        int actResult2 = minCostII.minCostIIRefine(costs);
        Assertions.assertEquals(expectedResult, actResult2);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[][]{
                        {1, 5, 3},
                        {2, 9, 4}
                }, 5),
                arguments(new int[][]{
                        {1, 3},
                        {2, 4}
                }, 5)
        );
    }
}