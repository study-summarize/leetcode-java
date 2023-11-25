package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("买卖股票的最佳时机")
class LeetCode_121_maxProfitTest {

    private final LeetCode_121_maxProfit maxProfit = new LeetCode_121_maxProfit();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(int[] prices, int expectedResult) {
        int actResult = maxProfit.maxProfit(prices);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{7, 1, 5, 3, 6, 4}, 5),
                arguments(new int[]{7, 6, 4, 3, 1}, 0)
        );
    }
}