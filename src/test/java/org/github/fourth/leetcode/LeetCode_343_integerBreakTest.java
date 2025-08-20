package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("343. 整数拆分")
class LeetCode_343_integerBreakTest {
    private final LeetCode_343_integerBreak instance = new LeetCode_343_integerBreak();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void testOrigin02(int n, int expectedResult) {
        int actResult = instance.integerBreak(n);
        Assertions.assertEquals(actResult, expectedResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(2, 1),
                arguments(10, 36)
        );
    }


}