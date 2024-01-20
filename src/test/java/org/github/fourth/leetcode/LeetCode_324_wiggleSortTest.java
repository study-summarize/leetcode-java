package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("摆动排序 II")
class LeetCode_324_wiggleSortTest {
    private final LeetCode_324_wiggleSort leetCode324WiggleSort = new LeetCode_324_wiggleSort();


    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(int[] nums, int[] expectedResult) {
        leetCode324WiggleSort.wiggleSort(nums);
        Assertions.assertArrayEquals(expectedResult, nums);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{1, 5, 1, 1, 6, 4}, new int[]{1, 6, 1, 5, 1, 4}),
                arguments(new int[]{1, 3, 2, 2, 3, 1}, new int[]{2, 3, 1, 3, 1, 2})
        );
    }


}