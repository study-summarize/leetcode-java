package org.github.fourth.leetcode;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("283. 移动零")
class LeetCode_283_moveZeroesTest {
    private final LeetCode_283_moveZeroes instance = new LeetCode_283_moveZeroes();

//    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(int[] nums, int[] expectedResult) {
        instance.moveZeroes(nums);
        Assertions.assertArrayEquals(expectedResult, nums);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{0, 1, 0, 3, 12}, new int[]{1, 3, 12, 0, 0}),
                arguments(new int[]{0}, new int[]{0})
        );
    }

}