package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("接雨水")
public class LeetCode_042_trapTest {

    private final LeetCode_042_trap trapTest = new LeetCode_042_trap();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(int[] height, int waterCount) {
        Assertions.assertEquals(waterCount, trapTest.trap1(height));
    }
    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test02(int[] height, int waterCount) {
        Assertions.assertEquals(waterCount, trapTest.trap2(height));
    }
    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test03(int[] height, int waterCount) {
        Assertions.assertEquals(waterCount, trapTest.trap3(height));
    }
    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01Refine(int[] height, int waterCount) {
        Assertions.assertEquals(waterCount, trapTest.trap1Refine(height));
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}, 6),
                arguments(new int[]{4, 2, 0, 3, 2, 5}, 9)
        );
    }
}
