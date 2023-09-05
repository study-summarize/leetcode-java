package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("XXX测试")
class Test_053_maxSubArrayTest {

    private final Test_053_maxSubArray maxSubArray = new Test_053_maxSubArray();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(int[] nums, int expectedResult) {

        int actResult1 = maxSubArray.maxSubArray(nums);
        Assertions.assertEquals(expectedResult, actResult1);

        int actResult2 = maxSubArray.maxSubArrayRefine(nums);
        Assertions.assertEquals(expectedResult, actResult2);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
        );
    }

}