package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.Function;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("找出字符串中第一个匹配项的下标")
class LeetCode_028_strStrTest {

    private final LeetCode_028_strStr strStr = new LeetCode_028_strStr();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(String haystack, String needle, int expectedResult) {
        commonTest(expectedResult, x -> x.strStr01(haystack, needle));
    }
//    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test02(String haystack, String needle, int expectedResult) {
        commonTest(expectedResult, x -> x.strStr02(haystack, needle));
    }

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test03(String haystack, String needle, int expectedResult) {
        commonTest(expectedResult, x -> x.strStr03(haystack, needle));
    }

    private void commonTest(int expectedResult, Function<LeetCode_028_strStr, Integer> function) {
        Integer actResult = function.apply(strStr);
        Assertions.assertEquals(expectedResult, actResult);
    }


    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments("sadbutsad", "sad", 0),
//                arguments("mississippi", "issipi", 0),
                arguments("leetcode", "leeto", -1)
        );
    }

}