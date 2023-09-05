package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("最大子数组和测试")
class Test_053_maxSubArrayTest {

    private final Test_053_maxSubArray maxSubArray = new Test_053_maxSubArray();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(int[] nums, int expectedResult) {

        int actResult1 = maxSubArray.maxSubArray(nums);
        Assertions.assertEquals(expectedResult, actResult1);

        int actResult2 = maxSubArray.maxSubArrayRefine(nums);
        Assertions.assertEquals(expectedResult, actResult2);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}, 6),
                arguments(new int[]{5, 4, -1, 7, 8}, 23),
                arguments(new int[]{1}, 1)
        );
    }

}