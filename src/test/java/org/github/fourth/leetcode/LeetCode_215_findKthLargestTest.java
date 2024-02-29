package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("数组中的第K大元素")
class LeetCode_215_findKthLargestTest {
    private final LeetCode_215_findKthLargest findKthLargest = new LeetCode_215_findKthLargest();
//    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(int[] nums, int k, int expectedResult) {
        int actResult1 = findKthLargest.findKthLargest01(nums, k);
        Assertions.assertEquals(expectedResult, actResult1);
    }

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void testExample01(int[] nums, int k, int expectedResult) {
        int actResult1 = findKthLargest.findKthLargestExample01(nums, k);
        Assertions.assertEquals(expectedResult, actResult1);
    }

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test02(int[] nums, int k, int expectedResult) {
        int actResult2 = findKthLargest.findKthLargestExample02(nums, k);
        Assertions.assertEquals(expectedResult, actResult2);
    }

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test03(int[] nums, int k, int expectedResult) {
        int actResult3 = findKthLargest.findKthLargestExample03(nums, k);
        Assertions.assertEquals(expectedResult, actResult3);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{3, 2, 1, 5, 6, 4}, 2, 5),
                arguments(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4, 4)
        );
    }
}