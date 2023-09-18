package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("XXXX 测试")
class Test_1143_longestCommonSubsequenceTest {
    private final Test_1143_longestCommonSubsequence longestCommonSubsequence = new Test_1143_longestCommonSubsequence();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(String text1, String text2, int expectedResult) {
        int actResult = longestCommonSubsequence.longestCommonSubsequence(text1, text2);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}, 49),
                arguments(new int[]{1, 1}, 1)
        );
    }
}