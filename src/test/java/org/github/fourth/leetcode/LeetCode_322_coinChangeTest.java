package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("零钱兑换")
class LeetCode_322_coinChangeTest {
    private final LeetCode_322_coinChange coinChange = new LeetCode_322_coinChange();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(int[] coins, int amount, int expectedResult) {

        int actResult = coinChange.coinChange(coins, amount);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{1, 2, 5}, 11, 3),
                arguments(new int[]{2}, 3, -1),
                arguments(new int[]{1}, 0, 0)
        );
    }
}