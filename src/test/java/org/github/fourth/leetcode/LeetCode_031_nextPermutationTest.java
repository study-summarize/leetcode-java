package org.github.fourth.leetcode;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class LeetCode_031_nextPermutationTest {

    private final LeetCode_031_nextPermutation instance = new LeetCode_031_nextPermutation();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(int[] nums, int[] expectedResult) {
        instance.nextPermutation(nums);
        Assertions.assertArrayEquals(expectedResult, nums);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{1, 2, 3}, new int[]{1, 3, 2}),
                arguments(new int[]{3, 2, 1}, new int[]{1, 2, 3}),
                arguments(new int[]{1, 1, 5}, new int[]{1, 5, 1})
        );
    }

}