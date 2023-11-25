package leetcode;

import org.github.fourth.leetcode.LeetCode_213_rob;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("打家劫舍 II")
class LeetCode_213_robTest {
    private final LeetCode_213_rob rob = new LeetCode_213_rob();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(int[] nums, int expectedResult) {
        int actResult = rob.rob(nums);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{2, 3, 2}, 3),
                arguments(new int[]{1, 2, 3, 1}, 4),
                arguments(new int[]{1, 2, 3}, 3)
        );
    }
}