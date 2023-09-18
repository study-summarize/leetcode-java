package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("XXXX 测试")
class Test_1099_twoSumLessThanKTest {
    private final Test_1099_twoSumLessThanK test1099TwoSumLessThanK = new Test_1099_twoSumLessThanK();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(int[] nums, int k, int expectedResult) {
        int actResult = test1099TwoSumLessThanK.twoSumLessThanK(nums, k);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}, 49),
                arguments(new int[]{1, 1}, 1)
        );
    }
}