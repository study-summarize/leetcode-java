package leetcode;

import org.github.fourth.leetcode.LeetCode_340_lengthOfLongestSubstringKDistinctCharacters;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName(" 测试")
class LeetCode_340_lengthOfLongestSubstringKDistinctCharactersTest {
    private final LeetCode_340_lengthOfLongestSubstringKDistinctCharacters lengthOfLongestSubstringKDistinctCharacters = new LeetCode_340_lengthOfLongestSubstringKDistinctCharacters();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(String s, int k, int expectedResult) {

        int actResult = lengthOfLongestSubstringKDistinctCharacters.lengthOfLongestSubstringKDistinctCharacters(s, k);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}, 49),
                arguments(new int[]{1, 1}, 1)
        );
    }
}