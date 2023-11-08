package leetcode;

import org.github.fourth.leetcode.LeetCode_028_strStr;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("找出字符串中第一个匹配项的下标测试")
class Test_028_strStrTest {

    private final LeetCode_028_strStr strStr = new LeetCode_028_strStr();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(String haystack, String needle, int expectedResult) {
        int actResult1 = strStr.strStr01(haystack, needle);
        Assertions.assertEquals(expectedResult, actResult1);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments("sadbutsad", "sad", 0),
                arguments("leetcode", "leeto", -1)
        );
    }

}