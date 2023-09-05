package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("XXX测试")
class Test_028_strStrTest {

    private final Test_028_strStr strStr = new Test_028_strStr();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(String haystack, String needle, int expectedResult) {
        int actResult1 = strStr.strStr01(haystack, needle);
        Assertions.assertEquals(expectedResult, actResult1);

        int actResult2 = strStr.strStr02(haystack, needle);
        Assertions.assertEquals(expectedResult, actResult2);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
        );
    }

}