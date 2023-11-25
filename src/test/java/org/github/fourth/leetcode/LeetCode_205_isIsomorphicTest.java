package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("同构字符串")
class LeetCode_205_isIsomorphicTest {
    private final LeetCode_205_isIsomorphic isIsomorphic = new LeetCode_205_isIsomorphic();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(String s, String t, boolean expectedResult) {
        boolean actResult = isIsomorphic.isIsomorphic(s, t);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments("egg", "add", true),
                arguments("foo", "bar", false),
                arguments("paper", "title", true)
        );
    }
}