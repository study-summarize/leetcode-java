package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("最小覆盖子串")
class LeetCode_076_minWindowTest {
    private final LeetCode_076_minWindow minWindow = new LeetCode_076_minWindow();

//    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(String s, String t, String expectedResult) {
        String actResult = minWindow.minWindow(s, t);
        Assertions.assertEquals(expectedResult, actResult);
    }

//    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void testExample(String s, String t, String expectedResult) {
        String actResult = minWindow.minWindowExample(s, t);
        Assertions.assertEquals(expectedResult, actResult);
    }


    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments("ADOBECODEBANC", "ABC", "BANC"),
                arguments("a", "a", "a"),
                arguments("a", "aa", "")
        );
    }
}