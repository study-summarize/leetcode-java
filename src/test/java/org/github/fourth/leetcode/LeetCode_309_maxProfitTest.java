package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("买卖股票的最佳时机含冷冻期")
class LeetCode_309_maxProfitTest {
    private final LeetCode_309_maxProfit maxProfit = new LeetCode_309_maxProfit();

//    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(int[] prices, int expectedResult) {
        int actResult1 = maxProfit.maxProfit01(prices);
        Assertions.assertEquals(expectedResult, actResult1);
    }

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void testExample(int[] prices, int expectedResult) {
        int actResult1 = maxProfit.maxProfitExample(prices);
        Assertions.assertEquals(expectedResult, actResult1);

        int actResult2 = maxProfit.maxProfitRefineExample(prices);
        Assertions.assertEquals(expectedResult, actResult2);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{1, 2, 3, 0, 2}, 3),
                arguments(new int[]{1}, 0)
        );
    }
}