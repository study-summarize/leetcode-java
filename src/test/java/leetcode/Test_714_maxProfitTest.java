package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName(" 测试")
class Test_714_maxProfitTest {
    private final Test_714_maxProfit maxProfit = new Test_714_maxProfit();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(int[] prices, int fee, int expectedResult) {
        int actResult = maxProfit.maxProfit(prices, fee);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}, 49),
                arguments(new int[]{1, 1}, 1)
        );
    }
}