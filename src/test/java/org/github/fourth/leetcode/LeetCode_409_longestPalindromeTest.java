package org.github.fourth.leetcode;

import org.github.fourth.leetcode.lcr.LCR_187_iceBreakingGame;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("最长回文串")
public class LeetCode_409_longestPalindromeTest {
    private final LeetCode_409_longestPalindrome instance = new LeetCode_409_longestPalindrome();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(String s, int expectedResult) {
        int actResult = instance.longestPalindrome(s);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments("abccccdd", 7),
                arguments("aaa", 3),
                arguments("a", 1)
        );
    }
}