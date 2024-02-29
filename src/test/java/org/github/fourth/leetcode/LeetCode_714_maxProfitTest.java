package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("买卖股票的最佳时机含手续费")
class LeetCode_714_maxProfitTest {
    private final LeetCode_714_maxProfit maxProfit = new LeetCode_714_maxProfit();

//    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(int[] prices, int fee, int expectedResult) {
        int actResult = maxProfit.maxProfit01(prices, fee);
        Assertions.assertEquals(expectedResult, actResult);
    }
    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void testExample(int[] prices, int fee, int expectedResult) {
        int actResult = maxProfit.maxProfitExample(prices, fee);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{1, 3, 2, 8, 4, 9}, 2, 8),
                arguments(new int[]{1, 3, 7, 5, 10, 3}, 3, 6)
        );
    }
}