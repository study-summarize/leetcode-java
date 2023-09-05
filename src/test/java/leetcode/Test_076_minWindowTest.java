package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("XXX测试")
class Test_076_minWindowTest {
    private final Test_076_minWindow minWindow = new Test_076_minWindow();
    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(String s, String t, String expectedResult) {

        String actResult = minWindow.minWindow(s, t);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
        );
    }
}