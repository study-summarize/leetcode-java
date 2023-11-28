package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("山脉数组的峰顶索引")
public class LeetCode_852_peakIndexInMountainArrayTest {
    private final LeetCode_852_peakIndexInMountainArray leetCode852PeakIndexInMountainArray = new LeetCode_852_peakIndexInMountainArray();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(int[] arr, int expectedResult) {
        int actResult = leetCode852PeakIndexInMountainArray.peakIndexInMountainArray(Arrays.copyOf(arr, arr.length));
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{0, 1, 0}, 1),
                arguments(new int[]{0, 2, 1, 0}, 1),
                arguments(new int[]{0, 10, 5, 2}, 1)
        );
    }
}
