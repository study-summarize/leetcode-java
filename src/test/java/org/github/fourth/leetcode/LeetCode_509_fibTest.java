package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("斐波那契数")
class LeetCode_509_fibTest {
    private final LeetCode_509_fib fib = new LeetCode_509_fib();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(int n, int expectedResult) {
        int actResult1 = fib.fib01(n);
        Assertions.assertEquals(expectedResult, actResult1);

        int actResult2 = fib.fib02(n);
        Assertions.assertEquals(expectedResult, actResult2);

        int actResult3 = fib.fib03(n);
        Assertions.assertEquals(expectedResult, actResult3);

        int actResult4 = fib.fib04(n);
        Assertions.assertEquals(expectedResult, actResult4);
    }

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void testExample(int n, int expectedResult) {
        int actResult1 = fib.fib1Example(n);
        Assertions.assertEquals(expectedResult, actResult1);

        int actResult2 = fib.fib2Example(n);
        Assertions.assertEquals(expectedResult, actResult2);

        int actResult3 = fib.fib3Example(n);
        Assertions.assertEquals(expectedResult, actResult3);

        int actResult4 = fib.fib4Example(n);
        Assertions.assertEquals(expectedResult, actResult4);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(2, 1),
                arguments(3, 2),
                arguments(4, 3)
        );
    }
}