package leetcode;

import org.github.fourth.leetcode.LeetCode_139_wordBreak;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("单词拆分")
class LeetCode_139_wordBreakTest {
    private final LeetCode_139_wordBreak wordBreak = new LeetCode_139_wordBreak();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(String s, List<String> wordDict, boolean expectedResult) {
        boolean actResult = wordBreak.wordBreak(s, wordDict);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments("leetcode", List.of("leet", "code"), true),
                arguments("catsandog", List.of("cats", "dog", "sand", "and", "cat"), false),
                arguments("applepenapple", List.of("apple", "pen"), true)
        );
    }
}