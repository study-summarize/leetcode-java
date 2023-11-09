package leetcode;

import org.github.fourth.leetcode.LeetCode_152_maxProduct;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("乘积最大子数组 测试")
class LeetCode_152_maxProductTest {
    private final LeetCode_152_maxProduct maxProduct = new LeetCode_152_maxProduct();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(int[] nums, int expectedResult) {
        int actResult = maxProduct.maxProduct(nums);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{2, 3, -2, 4}, 6),
                arguments(new int[]{-2, 0, -1}, 0)
        );
    }
}