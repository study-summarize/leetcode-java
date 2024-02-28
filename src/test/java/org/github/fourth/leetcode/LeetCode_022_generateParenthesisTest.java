package org.github.fourth.leetcode;

import org.github.fourth.VerifyUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("括号生成")
class LeetCode_022_generateParenthesisTest {
    private final LeetCode_022_generateParenthesis leetCode022GenerateParenthesis = new LeetCode_022_generateParenthesis();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(int n, List<String> expectedResult) {
        List<String> actResult = leetCode022GenerateParenthesis.generateParenthesis01(n);
        Assertions.assertTrue(VerifyUtils.assertListEquals(expectedResult, actResult));
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(3, List.of("((()))", "(()())", "(())()", "()(())", "()()()")),
                arguments(1, List.of("()"))
        );
    }


}