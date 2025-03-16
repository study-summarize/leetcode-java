package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class LeetCode_347_topKFrequentTest {
    private LeetCode_347_topKFrequent instance = new LeetCode_347_topKFrequent();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(int[] nums, int k, int[] expectedResults) {
        int[] actResult = instance.topKFrequent(nums, k);
        Assertions.assertArrayEquals(expectedResults, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{1, 1, 1, 2, 2, 3}, 2, new int[]{2, 1}),
                arguments(new int[]{1}, 1, new int[]{1})
        );
    }

}