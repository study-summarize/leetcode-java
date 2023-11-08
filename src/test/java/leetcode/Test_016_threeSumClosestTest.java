package leetcode;

import org.github.fourth.leetcode.LeetCode_016_threeSumClosest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("最接近的三数之和测试")
class Test_016_threeSumClosestTest {
    private final LeetCode_016_threeSumClosest threeSumClosest = new LeetCode_016_threeSumClosest();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(int[] nums, int target, int expectedResult) {
        int actResult = threeSumClosest.threeSumClosest(nums, target);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{-1, 2, 1, -4}, 1, 2),
                arguments(new int[]{0, 0, 0}, 1, 0)
        );
    }
}