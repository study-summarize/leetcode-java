package leetcode;

import org.github.fourth.leetcode.LeetCode_209_minSubArrayLen;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("长度最小的子数组 测试")
class LeetCode_209_minSubArrayLenTest {
    private final LeetCode_209_minSubArrayLen minSubArrayLen = new LeetCode_209_minSubArrayLen();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(int target, int[] nums, int expectedResult) {
        int actResult = minSubArrayLen.minSubArrayLen(target, nums);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{1,8,6,2,5,4,8,3,7}, 49),
                arguments(new int[]{1,1}, 1)
        );
    }
}