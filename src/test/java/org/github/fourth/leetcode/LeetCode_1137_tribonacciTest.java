package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("第 N 个泰波那契数")
class LeetCode_1137_tribonacciTest {

    private final LeetCode_1137_tribonacci tribonacci = new LeetCode_1137_tribonacci();


    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(int n, int expectedResult) {
        int actResult = tribonacci.tribonacci(n);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(4, 4),
                arguments(25, 1389537)
        );
    }
}
