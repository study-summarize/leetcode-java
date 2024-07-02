package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("128. 最长连续序列")
class LeetCode_128_longestConsecutiveTest {
    private final LeetCode_128_longestConsecutive instance = new LeetCode_128_longestConsecutive();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(int[] nums, int expectedResult) {
        int actResult = instance.longestConsecutive(nums);
        Assertions.assertEquals(expectedResult, actResult);
    }


    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{100, 4, 200, 1, 3, 2}, 4),
                arguments(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}, 9)
        );
    }
}