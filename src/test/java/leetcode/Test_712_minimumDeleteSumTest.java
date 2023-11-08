package leetcode;

import org.github.fourth.leetcode.LeetCode_712_minimumDeleteSum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName(" 测试")
class Test_712_minimumDeleteSumTest {
    private final LeetCode_712_minimumDeleteSum minimumDeleteSum = new LeetCode_712_minimumDeleteSum();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(String s1, String s2, int expectedResult) {
        int actResult = minimumDeleteSum.minimumDeleteSum(s1, s2);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}, 49),
                arguments(new int[]{1, 1}, 1)
        );
    }
}