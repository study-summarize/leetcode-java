package leetcode;

import org.github.fourth.leetcode.LeetCode_509_fib;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName(" 测试")
class Test_509_fibTest {
    private final LeetCode_509_fib fib = new LeetCode_509_fib();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(int n, int expectedResult) {
        int actResult1 = fib.fib1(n);
        Assertions.assertEquals(expectedResult, actResult1);

        int actResult2 = fib.fib2(n);
        Assertions.assertEquals(expectedResult, actResult2);

        int actResult3 = fib.fib3(n);
        Assertions.assertEquals(expectedResult, actResult3);

        int actResult4 = fib.fib4(n);
        Assertions.assertEquals(expectedResult, actResult4);

    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}, 49),
                arguments(new int[]{1, 1}, 1)
        );
    }
}