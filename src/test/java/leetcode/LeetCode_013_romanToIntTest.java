package leetcode;

import org.github.fourth.leetcode.LeetCode_013_romanToInt;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("罗马数字转整数测试")
class LeetCode_013_romanToIntTest {

    private final LeetCode_013_romanToInt romanToInt = new LeetCode_013_romanToInt();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(String s, int expectedResult) {
        int actResult = romanToInt.romanToInt(s);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments("III", 3),
                arguments("LVIII", 58),
                arguments("IX", 9),
                arguments("MCMXCIV", 1994),
                arguments("IV", 4)
        );
    }

}