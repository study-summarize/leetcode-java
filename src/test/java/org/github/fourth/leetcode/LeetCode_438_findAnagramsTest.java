package org.github.fourth.leetcode;

import org.github.fourth.VerifyUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("438. 找到字符串中所有字母异位词")
class LeetCode_438_findAnagramsTest {
    private final LeetCode_438_findAnagrams instance = new LeetCode_438_findAnagrams();

//    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test02(String s, String p, List<Integer> expectedResult) {
        List<Integer> actResult = instance.findAnagrams(s, p);
        VerifyUtils.assertListEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments("cbaebabacd", "abc", Arrays.asList(0, 6)),
                arguments("abab", "ab", Arrays.asList(0, 1, 2))
        );
    }
}