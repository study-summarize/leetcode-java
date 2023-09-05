package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("XXXX")
class Test_140_wordBreakTest {
    private final Test_140_wordBreak wordBreak = new Test_140_wordBreak();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(String s, List<String> wordDict, List<String> expectedResult) {
        List<String> actResult1 = wordBreak.wordBreak(s, wordDict);
        Assertions.assertArrayEquals(expectedResult.toArray(), actResult1.toArray());

        List<String> actResult2 = wordBreak.wordBreak01(s, wordDict);
        Assertions.assertArrayEquals(expectedResult.toArray(), actResult2.toArray());
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{1,8,6,2,5,4,8,3,7}, 49),
                arguments(new int[]{1,1}, 1)
        );
    }

}