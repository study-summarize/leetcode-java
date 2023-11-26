package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("单词拆分 II")
class LeetCode_140_wordBreakTest {
    private final LeetCode_140_wordBreak wordBreak = new LeetCode_140_wordBreak();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(String s, List<String> wordDict, List<String> expectedResult) {
        commonTest(expectedResult, x -> x.wordBreak(s, wordDict));
    }
    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(String s, List<String> wordDict, List<String> expectedResult) {
        commonTest(expectedResult, x -> x.wordBreak01(s, wordDict));
    }

    private void commonTest(List<String> expectedResult, Function<LeetCode_140_wordBreak, List<String>> function) {
        Set<String> finalExpectedResult = new HashSet<>(expectedResult);

        Set<String> actResult = new HashSet<>(function.apply(wordBreak));
        Assertions.assertEquals(expectedResult.size(), actResult.size());
        actResult.removeAll(finalExpectedResult);
        Assertions.assertEquals(0, actResult.size());
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments("catsanddog", List.of("cat", "cats", "and", "sand", "dog"), List.of("cats and dog", "cat sand dog")),
                arguments("catsandog", List.of("cats", "dog", "sand", "and", "cat"), List.of()),
                arguments("pineapplepenapple", List.of("apple", "pen", "applepen", "pine", "pineapple"), List.of("pine apple pen apple", "pineapple pen apple", "pine applepen apple"))
        );
    }

}