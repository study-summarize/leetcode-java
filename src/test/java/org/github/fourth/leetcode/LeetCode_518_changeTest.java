package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("零钱兑换 II")
class LeetCode_518_changeTest {
    private final LeetCode_518_change change = new LeetCode_518_change();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(int amount, int[] coins, int expectedResult) {
        int actResult = this.change.change(amount, coins);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(5, new int[]{1, 2, 5}, 4),
                arguments(3, new int[]{2}, 0),
                arguments(10, new int[]{10}, 1)
        );
    }
}