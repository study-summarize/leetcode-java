package org.github.fourth.leetcode.lcr;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("LCR 170. 交易逆序对的总数")
class LCR_170_reversePairsTest {
    private final LCR_170_reversePairs lcr170ReversePairs = new LCR_170_reversePairs();
    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(int[] record, int expectedResult) {
        int actResult = lcr170ReversePairs.reversePairs01(record);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{9, 7, 5, 4, 6}, 8)
        );
    }

}