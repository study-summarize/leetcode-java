package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("翻转对")
class LeetCode_493_reversePairsTest {
    private final LeetCode_493_reversePairs reversePairs = new LeetCode_493_reversePairs();

//    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(int[] nums, int expectedResult) {
        int actResult = reversePairs.reversePairs01(nums);
        Assertions.assertEquals(expectedResult, actResult);
    }
    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void testExample(int[] nums, int expectedResult) {
        int actResult = reversePairs.reversePairsExample(nums);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{1, 3, 2, 3, 1}, 2),
                arguments(new int[]{2, 4, 3, 5, 1}, 3)
        );
    }
}