package leetcode;

import org.github.fourth.leetcode.LeetCode_739_dailyTemperatures;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("每日温度")
public class LeetCode_739_dailyTemperaturesTest {

    private final LeetCode_739_dailyTemperatures leetCode739 = new LeetCode_739_dailyTemperatures();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(int[] temperatures, int[] expectedResult) {
        int[] actResult = leetCode739.dailyTemperatures(Arrays.copyOf(temperatures, temperatures.length));
        Assertions.assertEquals(expectedResult.length, actResult.length);
        for (int i = 0; i < expectedResult.length; i++) {
            Assertions.assertEquals(expectedResult[i], actResult[i]);
        }
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{73, 74, 75, 71, 69, 72, 76, 73}, new int[]{1, 1, 4, 2, 1, 1, 0, 0}),
                arguments(new int[]{30, 40, 50, 60}, new int[]{1, 1, 1, 0}),
                arguments(new int[]{30, 60, 90}, new int[]{1, 1, 0})
        );
    }
}
