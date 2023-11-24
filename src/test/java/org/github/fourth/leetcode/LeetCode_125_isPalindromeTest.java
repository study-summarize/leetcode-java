package org.github.fourth.leetcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("验证回文串")
class LeetCode_125_isPalindromeTest {
    private final LeetCode_125_isPalindrome leetCode125IsPalindrome = new LeetCode_125_isPalindrome();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(String s, boolean expectedResult) {
        boolean actResult = leetCode125IsPalindrome.isPalindrome(s);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments("A man, a plan, a canal: Panama", true),
                arguments("race a car", false),
                arguments(" ", true)
        );
    }

}