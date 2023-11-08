package leetcode;

import org.github.fourth.leetcode.LeetCode_344_reverseString;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("反转字符串")
public class LeetCode_344_reverseStringTest {

    private static final LeetCode_344_reverseString leetCode344 = new LeetCode_344_reverseString();

//    @ParameterizedTest
    @MethodSource("generateOriginRightCase")
    public void testOrigin(char[] s, char[] expectedResults) {
        char[] actResult01 = Arrays.copyOf(s, s.length);
        char[] actResult = Arrays.copyOf(s, s.length);
        leetCode344.reverseStringExample(actResult);
        leetCode344.reverseString(actResult01);

        Assertions.assertEquals(expectedResults.length, actResult.length);
        Assertions.assertEquals(expectedResults.length, actResult01.length);
        for (int i = 0; i < expectedResults.length; i++) {
            Assertions.assertEquals(expectedResults[i], actResult[i]);
            Assertions.assertEquals(expectedResults[i], actResult01[i]);
        }
    }

    public static Stream<Arguments> generateOriginRightCase() {
        return Stream.of(
                arguments(new char[]{'h', 'e', 'l', 'l', 'o'}, new char[]{'o', 'l', 'l', 'e', 'h'}),
                arguments(new char[]{'H', 'a', 'n', 'n', 'a', 'h'}, new char[]{'h', 'a', 'n', 'n', 'a', 'H'})
        );
    }
}
