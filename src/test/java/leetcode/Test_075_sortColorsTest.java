package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("XXX测试")
class Test_075_sortColorsTest {

    private final Test_075_sortColors sortColors = new Test_075_sortColors();
    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(int[] nums, int[] expectedResult) {

        sortColors.sortColors(nums);
        Assertions.assertArrayEquals(expectedResult, nums);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
        );
    }
}