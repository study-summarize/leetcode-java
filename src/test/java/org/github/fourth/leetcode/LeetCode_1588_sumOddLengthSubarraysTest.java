package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("所有奇数长度子数组的和")
public class LeetCode_1588_sumOddLengthSubarraysTest {

    private static final LeetCode_1588_sumOddLengthSubarrays leetCode1588 = new LeetCode_1588_sumOddLengthSubarrays();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(int[] arr, int expectedResults) {
        commonTest(expectedResults, x -> x.sumOddLengthSubarrays(arr));
    }
    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test02(int[] arr, int expectedResults) {
        commonTest(expectedResults, x -> x.sumOddLengthSubarrays02(arr));
    }
    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void testExample(int[] arr, int expectedResults) {
        commonTest(expectedResults, x -> x.sumOddLengthSubarraysExample(arr));
    }

    private void commonTest(int expectedResults, Function<LeetCode_1588_sumOddLengthSubarrays, Integer> function) {
        Assertions.assertEquals(expectedResults, function.apply(leetCode1588));
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{1, 4, 2, 5, 3}, 58),
                arguments(new int[]{1, 2}, 3),
                arguments(new int[]{10, 11, 12}, 66)
        );
    }
}
