package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("存在重复元素")
class LeetCode_217_containDuplicateTest {
    private final LeetCode_217_containDuplicate containDuplicate = new LeetCode_217_containDuplicate();

//    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(int[] nums, boolean expectedResult) {
        boolean actResult = containDuplicate.containsDuplicate01(nums);
        Assertions.assertEquals(expectedResult, actResult);
    }

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void testExample(int[] nums, boolean expectedResult) {
        boolean actResult = containDuplicate.containsDuplicateExample(nums);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{1, 2, 3, 1}, true),
                arguments(new int[]{1, 2, 3, 4}, false),
                arguments(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}, true)
        );
    }
}