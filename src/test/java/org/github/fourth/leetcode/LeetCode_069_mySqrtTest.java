package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("x 的平方根")
public class LeetCode_069_mySqrtTest {

    private final LeetCode_069_mySqrt leetCode069MySqrt = new LeetCode_069_mySqrt();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(int x, int expectedResult) {
        int actResult = leetCode069MySqrt.mySqrt(x);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(4, 2),
                arguments(2147395599, 46339),
                arguments(8, 2)
        );
    }
}
