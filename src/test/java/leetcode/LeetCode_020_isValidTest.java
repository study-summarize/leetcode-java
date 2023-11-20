package leetcode;

import org.github.fourth.leetcode.LeetCode_020_isValid;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("有效的括号")
public class LeetCode_020_isValidTest {
    private final LeetCode_020_isValid isValid = new LeetCode_020_isValid();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(String s, boolean expectedResult) {
        Assertions.assertEquals(expectedResult, isValid.isValid(s));
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments("()", true),
                arguments("(]", false),
                arguments("()[]{}", true)
        );
    }
}
