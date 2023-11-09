package leetcode;

import org.github.fourth.leetcode.LeetCode_188_maxProfit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("买卖股票的最佳时机 IV 测试")
class LeetCode_188_maxProfitTest {
    private final LeetCode_188_maxProfit maxProfit = new LeetCode_188_maxProfit();

//    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(int k, int[] prices, int expectedResult) {
        int actResult = maxProfit.maxProfit(k, prices);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(2, new int[]{2, 4, 1}, 2),
                arguments(2, new int[]{3, 2, 6, 5, 0, 3}, 7)
        );
    }
}