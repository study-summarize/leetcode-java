package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("189. 轮转数组")
class LeetCode_189_rotateTest {
    private final LeetCode_189_rotate instance = new LeetCode_189_rotate();


//    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void testExample(int[] nums, int k, int[] expectedResult) {
        instance.rotate(nums, k);
        Assertions.assertArrayEquals(expectedResult, nums);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{1, 2, 3, 4, 5, 6, 7}, 3, new int[]{5, 6, 7, 1, 2, 3, 4}),
                arguments(new int[]{-1, -100, 3, 99}, 2, new int[]{3, 99, -1, -100})
        );
    }
}