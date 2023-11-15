package leetcode;

import org.github.fourth.leetcode.LeetCode_1588_sumOddLengthSubarrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("所有奇数长度子数组的和")
public class LeetCode_1588_sumOddLengthSubarraysTest {

    private static final LeetCode_1588_sumOddLengthSubarrays leetCode1588 = new LeetCode_1588_sumOddLengthSubarrays();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(int[] arr, int expectedResults) {
        int actResult01 = leetCode1588.sumOddLengthSubarrays(Arrays.copyOf(arr, arr.length));
        int actResult02 = leetCode1588.sumOddLengthSubarrays02(Arrays.copyOf(arr, arr.length));
        int actResultExample = leetCode1588.sumOddLengthSubarraysExample(Arrays.copyOf(arr, arr.length));

        Assertions.assertEquals(expectedResults, actResult01);
        Assertions.assertEquals(expectedResults, actResult02);
        Assertions.assertEquals(expectedResults, actResultExample);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{1, 4, 2, 5, 3}, 58),
                arguments(new int[]{1, 2}, 3),
                arguments(new int[]{10, 11, 12}, 66)
        );
    }
}
