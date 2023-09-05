package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("XXXX")
class Test_139_wordBreakTest {
    private final Test_139_wordBreak wordBreak = new Test_139_wordBreak();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(String s, List<String> wordDict, boolean expectedResult) {
        boolean actResult = wordBreak.wordBreak(s, wordDict);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{1,8,6,2,5,4,8,3,7}, 49),
                arguments(new int[]{1,1}, 1)
        );
    }
}