package leetcode;

import org.github.fourth.leetcode.LeetCode_238_productExceptSelf;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("除自身以外数组的乘积")
public class LeetCode_238_productExceptSelfTest {

    private static final LeetCode_238_productExceptSelf leetCode238 = new LeetCode_238_productExceptSelf();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(int[] nums, int[] expectedResults) {
        int[] actResult = leetCode238.productExceptSelf(Arrays.copyOf(nums, nums.length));
        int[] actResultExample = leetCode238.productExceptSelfExample(Arrays.copyOf(nums, nums.length));

        Assertions.assertEquals(expectedResults.length, actResult.length);
        Assertions.assertEquals(expectedResults.length, actResultExample.length);
        for (int i = 0; i < expectedResults.length; i++) {
            Assertions.assertEquals(expectedResults[i], actResult[i]);
            Assertions.assertEquals(expectedResults[i], actResultExample[i]);
        }
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{1, 2, 3, 4}, new int[]{24, 12, 8, 6}),
                arguments(new int[]{-1, 1, 0, -3, 3}, new int[]{0, 0, 9, 0, 0})
        );
    }
}
