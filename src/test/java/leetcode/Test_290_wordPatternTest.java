package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName(" 测试")
class Test_290_wordPatternTest {
    private final Test_290_wordPattern wordPattern = new Test_290_wordPattern();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(String pattern, String s, List<String> expectedResult) {
        boolean actResult = wordPattern.wordPattern(pattern, s);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}, 49),
                arguments(new int[]{1, 1}, 1)
        );
    }
}