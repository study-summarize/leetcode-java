package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("买卖股票的最佳时机 III 测试")
class Test_123_maxProfitTest {
    private final Test_123_maxProfit maxProfit = new Test_123_maxProfit();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(int[] prices, int expectedResult) {
        int actResult = maxProfit.maxProfit(prices);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{3, 3, 5, 0, 0, 3, 1, 4}, 6),
                arguments(new int[]{1, 2, 3, 4, 5}, 4),
                arguments(new int[]{7, 6, 4, 3, 1}, 0),
                arguments(new int[]{1}, 0)
        );
    }
}