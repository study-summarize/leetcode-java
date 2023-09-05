package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("XXXX")
class Test_377_combinationSum4Test {
    private final Test_377_combinationSum4 combinationSum4 = new Test_377_combinationSum4();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(int[] nums, int target, int expectedResult) {
        int actResult = combinationSum4.combinationSum4(nums, target);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}, 49),
                arguments(new int[]{1, 1}, 1)
        );
    }
}