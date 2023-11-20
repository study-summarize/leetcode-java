package leetcode;

import org.github.fourth.leetcode.LeetCode_150_evalRPN;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("逆波兰表达式求值")
public class LeetCode_150_evalRPNTest {
    private final LeetCode_150_evalRPN leetCode150EvalRPN = new LeetCode_150_evalRPN();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(String[] tokens, int expectedResult) {
        Assertions.assertEquals(expectedResult, leetCode150EvalRPN.evalRPN(Arrays.copyOf(tokens, tokens.length)));
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new String[]{"2", "1", "+", "3", "*"}, 9),
                arguments(new String[]{"4", "13", "5", "/", "+"}, 6),
                arguments(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}, 22)
        );
    }
}
