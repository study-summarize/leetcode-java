package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("有效的字母异位词")
class LeetCode_242_isAnagramTest {
    private final LeetCode_242_isAnagram isAnagram = new LeetCode_242_isAnagram();


//    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(String s, String t, boolean expectedResult) {
        boolean actResult = isAnagram.isAnagram01(s, t);
        Assertions.assertEquals(expectedResult, actResult);
    }

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void testExample(String s, String t, boolean expectedResult) {
        boolean actResult = isAnagram.isAnagramExample(s, t);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments("anagram", "nagaram", true),
                arguments("rat", "car", false)
        );
    }
}