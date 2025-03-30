package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LeetCode_014_longestCommonPrefixTest {
    private final LeetCode_014_longestCommonPrefix instance = new LeetCode_014_longestCommonPrefix();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(String[] strs, String expectedResult) {
        String actResult = instance.longestCommonPrefix(strs);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new String[]{"flower", "flow", "flight"}, "fl"),
                arguments(new String[]{"dog", "racecar", "car"}, "")
        );
    }
}