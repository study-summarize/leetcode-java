package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("整数转罗马数字测试")
public class Test_012_intToRomanTest {

    private final Test_012_intToRoman intToRoman = new Test_012_intToRoman();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(int num, String expectedResult) {
        String actResult = intToRoman.intToRoman(num);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(3, "III"),
                arguments(58, "LVIII"),
                arguments(9, "IX"),
                arguments(1994, "MCMXCIV"),
                arguments(4, "IV")
        );
    }

}
