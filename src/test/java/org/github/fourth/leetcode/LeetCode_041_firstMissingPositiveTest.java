package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("41. 缺失的第一个正数")
class LeetCode_041_firstMissingPositiveTest {
    private final LeetCode_041_firstMissingPositive instance = new LeetCode_041_firstMissingPositive();

//    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test03(int[] nums, int expectResult) {
        int actResult = instance.firstMissingPositive(nums);
        Assertions.assertEquals(expectResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{1, 2, 0}, 3),
                arguments(new int[]{3, 4, -1, 1}, 2),
                arguments(new int[]{7, 8, 9, 11, 12}, 1)
        );
    }

}