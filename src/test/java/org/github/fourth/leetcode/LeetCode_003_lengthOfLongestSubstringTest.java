package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.Function;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("无重复字符的最长子串测试")
public class LeetCode_003_lengthOfLongestSubstringTest {

    private final LeetCode_003_lengthOfLongestSubstring lengthOfLongestSubstring = new LeetCode_003_lengthOfLongestSubstring();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(String s, int expectedResults) {
        commonTest(expectedResults, x -> x.lengthOfLongestSubstring1(s));
    }
    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01Refine(String s, int expectedResults) {
        commonTest(expectedResults, x -> x.lengthOfLongestSubstring1Refine(s));
    }

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test02(String s, int expectedResults) {
        commonTest(expectedResults, x -> x.lengthOfLongestSubstring2(s));
    }

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test02Refine(String s, int expectedResults) {
        commonTest(expectedResults, x -> x.lengthOfLongestSubstring2Refine(s));
    }
    private void commonTest(int expectedResults, Function<LeetCode_003_lengthOfLongestSubstring, Integer> function) {
        Integer actResult = function.apply(lengthOfLongestSubstring);
        Assertions.assertEquals(expectedResults, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments("abcabcbb", 3),
                arguments("bbbbb", 1),
                arguments("pwwkew", 3)
        );
    }

}
