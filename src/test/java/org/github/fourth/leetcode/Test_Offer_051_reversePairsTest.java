package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("XXXX 测试")
class Test_Offer_051_reversePairsTest {
    private final Test_Offer_051_reversePairs reversePairs = new Test_Offer_051_reversePairs();

//    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(int[] nums, int expectedResult) {
        int actResult = reversePairs.reversePairs(nums);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
        );
    }
}