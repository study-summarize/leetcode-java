package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("下一个更大元素 I")
public class LeetCode_496_nextGreaterElementTest {
    private final LeetCode_496_nextGreaterElement extGreaterElement = new LeetCode_496_nextGreaterElement();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(int[] nums1, int[] nums2, int[] expectedResult) {
        int[] actResult = extGreaterElement.nextGreaterElement01(Arrays.copyOf(nums1, nums1.length), Arrays.copyOf(nums2, nums2.length));
        Assertions.assertEquals(expectedResult.length, actResult.length);
        for (int i = 0; i < expectedResult.length; i++) {
            Assertions.assertEquals(expectedResult[i], actResult[i]);
        }
    }

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(int[] nums1, int[] nums2, int[] expectedResult) {
        int[] actResult = extGreaterElement.nextGreaterElement02(Arrays.copyOf(nums1, nums1.length), Arrays.copyOf(nums2, nums2.length));
        Assertions.assertEquals(expectedResult.length, actResult.length);
        for (int i = 0; i < expectedResult.length; i++) {
            Assertions.assertEquals(expectedResult[i], actResult[i]);
        }
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2}, new int[]{-1, 3, -1}),
                arguments(new int[]{2, 4}, new int[]{1, 2, 3, 4}, new int[]{3, -1})
        );
    }
}
