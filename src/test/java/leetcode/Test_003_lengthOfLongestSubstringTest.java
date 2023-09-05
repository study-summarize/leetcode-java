package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("无重复字符的最长子串测试")
public class Test_003_lengthOfLongestSubstringTest {

    private final Test_003_lengthOfLongestSubstring lengthOfLongestSubstring = new Test_003_lengthOfLongestSubstring();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(String s, int expectedResults) {
        int actResult1 = lengthOfLongestSubstring.lengthOfLongestSubstring1(s);
        Assertions.assertEquals(expectedResults, actResult1);

        int actResult2 = lengthOfLongestSubstring.lengthOfLongestSubstring1Refine(s);
        Assertions.assertEquals(expectedResults, actResult2);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments("abcabcbb", 3),
                arguments("bbbbb", 1),
                arguments("pwwkew", 3)
        );
    }

}
