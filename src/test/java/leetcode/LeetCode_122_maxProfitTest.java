package leetcode;

import org.github.fourth.leetcode.LeetCode_122_maxProfit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("买卖股票的最佳时机 II测试")
class LeetCode_122_maxProfitTest {

    private final LeetCode_122_maxProfit maxProfit = new LeetCode_122_maxProfit();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(int[] prices, int expectedResult) {
        int actResult = maxProfit.maxProfit01(prices.clone());
        Assertions.assertEquals(expectedResult, actResult);

        int actResult2 = maxProfit.maxProfit02(prices.clone());
        Assertions.assertEquals(expectedResult, actResult2);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{7, 1, 5, 3, 6, 4}, 7),
                arguments(new int[]{1, 2, 3, 4, 5}, 4),
                arguments(new int[]{7, 6, 4, 3, 1}, 0)
        );
    }
}