package org.github.fourth.leetcode.lcr;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("LCR 187. 破冰游戏")
public class LCR_187_iceBreakingGameTest {
    private final LCR_187_iceBreakingGame instance = new LCR_187_iceBreakingGame();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(int num, int target, int expectedResult) {
        int actResult = instance.iceBreakingGame01(num, target);
        Assertions.assertEquals(expectedResult, actResult);
    }

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test02(int num, int target, int expectedResult) {
        int actResult = instance.iceBreakingGame02(num, target);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(7, 4, 1),
                arguments(12, 5, 0)
                );
    }

}