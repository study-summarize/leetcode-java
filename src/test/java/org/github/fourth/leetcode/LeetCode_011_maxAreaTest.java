package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("盛最多水的容器")
public class LeetCode_011_maxAreaTest {
    private final LeetCode_011_maxArea maxArea = new LeetCode_011_maxArea();


    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(int[] height, int expectedResult) {
        int actResult = maxArea.maxArea(height);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}, 49),
                arguments(new int[]{1, 1}, 1)
        );
    }
}
