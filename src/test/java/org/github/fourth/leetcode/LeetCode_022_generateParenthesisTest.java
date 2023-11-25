package org.github.fourth.leetcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("括号生成")
class LeetCode_022_generateParenthesisTest {
    private final LeetCode_022_generateParenthesis leetCode022GenerateParenthesis = new LeetCode_022_generateParenthesis();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(int n, List<String> expectedResult) {
        // todo: 如何验证？？？
        List<String> actResult = leetCode022GenerateParenthesis.generateParenthesis(n);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(3, List.of("((()))", "(()())", "(())()", "()(())", "()()()")),
                arguments(1, List.of("()"))
        );
    }


}