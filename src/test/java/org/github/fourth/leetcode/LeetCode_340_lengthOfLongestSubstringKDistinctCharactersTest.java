package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("340. 至多包含 K 个不同字符的最长子串")
class LeetCode_340_lengthOfLongestSubstringKDistinctCharactersTest {
    private final LeetCode_340_lengthOfLongestSubstringKDistinctCharacters lengthOfLongestSubstringKDistinctCharacters = new LeetCode_340_lengthOfLongestSubstringKDistinctCharacters();


    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(String s, int k, int expectedResult) {
        int actResult = lengthOfLongestSubstringKDistinctCharacters.lengthOfLongestSubstringKDistinctCharacters(s, k);
        Assertions.assertEquals(expectedResult, actResult);
    }

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void testExample(String s, int k, int expectedResult) {
        int actResult = lengthOfLongestSubstringKDistinctCharacters.lengthOfLongestSubstringKDistinctCharactersExample(s, k);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments("eceba", 2, 3),
                arguments("aa", 1, 2)
        );
    }
}