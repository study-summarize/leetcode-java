package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

// todo: 如何抽取测试代码
@DisplayName("合并两个有序数组")
public class LeetCode_088_mergeTest {

    private static final LeetCode_088_merge leetCode_088_merge = new LeetCode_088_merge();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(int[] nums1, int m, int[] nums2, int[] expectedResults) {
        int[] actResult = Arrays.copyOf(nums1, nums1.length);
        int[] actResultExample = Arrays.copyOf(nums1, nums1.length);

        leetCode_088_merge.merge(actResult, m, Arrays.copyOf(nums2, nums2.length), nums2.length);
        leetCode_088_merge.mergeExample(actResultExample, m, Arrays.copyOf(nums2, nums2.length), nums2.length);

        Assertions.assertEquals(expectedResults.length, actResult.length);
        Assertions.assertEquals(expectedResults.length, actResultExample.length);
        for (int i = 0; i < expectedResults.length; i++) {
            Assertions.assertEquals(expectedResults[i], actResult[i]);
            Assertions.assertEquals(expectedResults[i], actResultExample[i]);
        }
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, new int[]{1, 2, 2, 3, 5, 6}),
                arguments(new int[]{1}, 1, new int[0], new int[]{1}),
                arguments(new int[]{0}, 0, new int[]{1}, new int[]{1})
        );
    }
}
