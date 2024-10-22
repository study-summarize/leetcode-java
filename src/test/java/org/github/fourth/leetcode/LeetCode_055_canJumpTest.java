package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class LeetCode_055_canJumpTest {
    private LeetCode_055_canJump instance = new LeetCode_055_canJump();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(int[] nums, boolean expectedResult) {
        boolean result = instance.canJump(nums);
        Assertions.assertEquals(expectedResult, result);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(
                        new int[]{2, 3, 1, 1, 4}, true),
                arguments(
                        new int[]{3, 2, 1, 0, 4}, false)
        );
    }

}