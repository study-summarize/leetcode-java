package leetcode;

import org.github.fourth.leetcode.LeetCode_075_sortColors;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("XXX测试")
class Test_075_sortColorsTest {

    private final LeetCode_075_sortColors sortColors = new LeetCode_075_sortColors();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(int[] nums, int[] expectedResult) {
        sortColors.sortColors(nums);
        Assertions.assertArrayEquals(expectedResult, nums);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{2, 0, 2, 1, 1, 0}, new int[]{0, 0, 1, 1, 2, 2}),
                arguments(new int[]{2, 0, 1}, new int[]{0, 1, 2})
        );
    }
}