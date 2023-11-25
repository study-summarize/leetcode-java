package org.github.fourth.leetcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("分割回文串 II")
class LeetCode_132_minCutTest {
    private final LeetCode_132_minCut leetCode132MinCut = new LeetCode_132_minCut();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(String s, int expectedResult) {
        int actResult = leetCode132MinCut.minCut(s);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments("aab", 1),
                arguments("a", 0),
                arguments("ab", 1)
        );
    }

}