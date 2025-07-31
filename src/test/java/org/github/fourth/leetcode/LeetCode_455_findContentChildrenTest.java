package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("分发饼干")
class LeetCode_455_findContentChildrenTest {
    private static final LeetCode_455_findContentChildren instance = new LeetCode_455_findContentChildren();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(int[] g, int[] s, int expectedResult) {
        int actResult = instance.findContentChildren(g, s);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(
                        new int[]{1, 2, 3},
                        new int[]{1, 1},
                        1
                ),
                arguments(
                        new int[]{1, 2},
                        new int[]{1, 2, 3},
                        2)
        );
    }
}