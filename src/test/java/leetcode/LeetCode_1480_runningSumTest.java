package leetcode;

import org.github.fourth.leetcode.LeetCode_1480_runningSum;
import org.github.fourth.leetcode.LeetCode_303_NumArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("一维数组的动态和")
public class LeetCode_1480_runningSumTest {

    private static final LeetCode_1480_runningSum leetCode1480 = new LeetCode_1480_runningSum();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(int[] nums, int[] expectedResults) {
        int[] actResult01 = leetCode1480.runningSum(Arrays.copyOf(nums, nums.length));
        int[] actResultExample = leetCode1480.runningSumExample(Arrays.copyOf(nums, nums.length));

        Assertions.assertEquals(expectedResults.length, actResult01.length);
        Assertions.assertEquals(expectedResults.length, actResultExample.length);
        for (int i = 0; i < expectedResults.length; i++) {
            Assertions.assertEquals(expectedResults[i], actResult01[i]);
            Assertions.assertEquals(expectedResults[i], actResultExample[i]);
        }
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{1, 2, 3, 4}, new int[]{1, 3, 6, 10}),
                arguments(new int[]{1, 1, 1, 1, 1}, new int[]{1, 2, 3, 4, 5}),
                arguments(new int[]{3, 1, 2, 10, 1}, new int[]{3, 4, 6, 16, 17})
        );
    }
}
