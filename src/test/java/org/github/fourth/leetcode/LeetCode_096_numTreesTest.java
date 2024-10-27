package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class LeetCode_096_numTreesTest {
    private final LeetCode_096_numTrees instance = new LeetCode_096_numTrees();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(int n, int expectedResult) {
        int actResult = instance.numTrees(n);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(3, 5),
                arguments(1, 1)
        );
    }

}