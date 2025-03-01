package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("最长公共子序列")
class LeetCode_1143_longestCommonSubsequenceTest {
    private final LeetCode_1143_longestCommonSubsequence longestCommonSubsequence = new LeetCode_1143_longestCommonSubsequence();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(String text1, String text2, int expectedResult) {
        int actResult = longestCommonSubsequence.longestCommonSubsequence01(text1, text2);
        Assertions.assertEquals(expectedResult, actResult);

        int actResult2 = longestCommonSubsequence.longestCommonSubsequence01Refine(text1, text2);
        Assertions.assertEquals(expectedResult, actResult2);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments("abcde", "ace", 3),
                arguments("abc", "abc", 3),
                arguments("abc", "def", 0)
        );
    }
}