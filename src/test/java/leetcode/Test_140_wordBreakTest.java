package leetcode;

import org.github.fourth.leetcode.LeetCode_140_wordBreak;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("单词拆分 II 测试")
class Test_140_wordBreakTest {
    private final LeetCode_140_wordBreak wordBreak = new LeetCode_140_wordBreak();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(String s, List<String> wordDict, List<String> expectedResult) {
        Set<String> finalExpectedResult = new HashSet<>(expectedResult);

        Set<String> actResult1 = new HashSet<>(wordBreak.wordBreak(s, wordDict));
        Assertions.assertEquals(expectedResult.size(), actResult1.size());
        actResult1.removeAll(finalExpectedResult);
        Assertions.assertEquals(0, actResult1.size());

        Set<String> actResult2 = new HashSet<>(wordBreak.wordBreak01(s, wordDict));
        Assertions.assertEquals(expectedResult.size(), actResult2.size());
        actResult2.removeAll(finalExpectedResult);
        Assertions.assertEquals(0, actResult2.size());
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments("catsanddog", List.of("cat", "cats", "and", "sand", "dog"), List.of("cats and dog", "cat sand dog")),
                arguments("catsandog", List.of("cats", "dog", "sand", "and", "cat"), List.of()),
                arguments("pineapplepenapple", List.of("apple", "pen", "applepen", "pine", "pineapple"), List.of("pine apple pen apple", "pineapple pen apple", "pine applepen apple"))
        );
    }

}