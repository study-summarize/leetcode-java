package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("买卖股票的最佳时机 IV")
class LeetCode_188_maxProfitTest {
    private final LeetCode_188_maxProfit maxProfit = new LeetCode_188_maxProfit();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(int k, int[] prices, int expectedResult) {
        int actResult = maxProfit.maxProfit01(k, prices);
        Assertions.assertEquals(expectedResult, actResult);
    }

//    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void testExample(int k, int[] prices, int expectedResult) {
        int actResult = maxProfit.maxProfitExample(k, prices);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(2, new int[]{2, 4, 1}, 2),
                arguments(2, new int[]{3, 2, 6, 5, 0, 3}, 7)
        );
    }
}