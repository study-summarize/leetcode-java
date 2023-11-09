package leetcode;

import org.github.fourth.leetcode.LeetCode_120_minimumTotal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("三角形最小路径和测试")
class LeetCode_120_minimumTotalTest {
    private final LeetCode_120_minimumTotal minimumTotal = new LeetCode_120_minimumTotal();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(List<List<Integer>> triangle, int expectedResult) {
        int actResult = minimumTotal.minimumTotal(triangle);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(Arrays.asList(List.of(2), List.of(3, 4), List.of(6, 5, 7), List.of(4, 1, 8, 3)), 11),
                arguments(List.of(List.of(-10)), -10)
        );
    }
}