package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;


@DisplayName("编辑距离")
class LeetCode_072_minDistanceTest {
    private final LeetCode_072_minDistance minDistance = new LeetCode_072_minDistance();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(String word1, String word2, int expectedResult) {
        int actResult = minDistance.minDistance(word1, word2);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments("horse", "ros", 3),
                arguments("intention", "execution", 5)
        );
    }
}