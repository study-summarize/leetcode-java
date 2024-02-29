package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("单词规律")
class LeetCode_290_wordPatternTest {
    private final LeetCode_290_wordPattern wordPattern = new LeetCode_290_wordPattern();

//    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(String pattern, String s, boolean expectedResult) {
        boolean actResult = wordPattern.wordPattern01(pattern, s);
        Assertions.assertEquals(expectedResult, actResult);
    }
    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void testExample(String pattern, String s, boolean expectedResult) {
        boolean actResult = wordPattern.wordPatternExample(pattern, s);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments("abba", "dog cat cat dog", true),
                arguments("abba", "dog cat cat fish", false),
                arguments("aaaa", "dog cat cat dog", false)
        );
    }
}