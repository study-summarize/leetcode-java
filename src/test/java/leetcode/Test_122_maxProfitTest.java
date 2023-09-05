package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("XXXX")
class Test_122_maxProfitTest {

    private final Test_122_maxProfit maxProfit = new Test_122_maxProfit();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(int[] prices, int expectedResult) {

        int actResult = maxProfit.maxProfit01(prices.clone());
        Assertions.assertEquals(expectedResult, actResult);

        int actResult2 = maxProfit.maxProfit02(prices.clone());
        Assertions.assertEquals(expectedResult, actResult2);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{1,1}, 1)
        );
    }
}