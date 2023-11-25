package org.github.fourth.leetcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("电话号码的字母组合")
class LeetCode_017_letterCombinationsTest {
    private final LeetCode_017_letterCombinations leetCode017LetterCombinations = new LeetCode_017_letterCombinations();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(String digits, List<String> expectedResult) {
        // todo: 如何验证？？？
        List<String> actResult = leetCode017LetterCombinations.letterCombinations(digits);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments("23", List.of("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf")),
                arguments("", List.of()),
                arguments("2", List.of("a", "b", "c"))
        );
    }


}