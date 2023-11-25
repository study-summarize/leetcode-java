package leetcode;

import org.github.fourth.leetcode.LeetCode_159_lengthOfLongestSubstringTwoDistinctCharacters;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("至多包含两个不同字符的最长子串")
class LeetCode_159_lengthOfLongestSubstringTwoDistinctCharactersTest {
    private final LeetCode_159_lengthOfLongestSubstringTwoDistinctCharacters lengthOfLongestSubstringTwoDistinctCharacters = new LeetCode_159_lengthOfLongestSubstringTwoDistinctCharacters();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(String s, int expectedResult) {
        int actResult = lengthOfLongestSubstringTwoDistinctCharacters.lengthOfLongestSubstringTwoDistinctCharacters(s);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments("eceba", 3),
                arguments("ccaabbb", 5)
        );
    }
}