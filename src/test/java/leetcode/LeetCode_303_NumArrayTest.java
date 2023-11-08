package leetcode;

import org.github.fourth.leetcode.LeetCode_303_NumArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("区域和检索 - 数组不可变")
public class LeetCode_303_NumArrayTest {

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(int[] nums, int left, int right, int expectedResults) {

        int actResult01 = new LeetCode_303_NumArray(Arrays.copyOf(nums, nums.length)).sumRange(left, right);
        int actResultExample = new LeetCode_303_NumArray(Arrays.copyOf(nums, nums.length)).sumRangeExample(left, right);

        Assertions.assertEquals(expectedResults, actResult01);
        Assertions.assertEquals(expectedResults, actResultExample);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{-2, 0, 3, -5, 2, -1}, 0, 2, 1),
                arguments(new int[]{-2, 0, 3, -5, 2, -1}, 2, 5, -1),
                arguments(new int[]{-2, 0, 3, -5, 2, -1}, 0, 5, -3)
        );
    }
}
