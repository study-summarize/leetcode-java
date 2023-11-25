package leetcode;

import org.github.fourth.leetcode.LeetCode_416_canPartition;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("分割等和子集")
class LeetCode_416_canPartitionTest {
    private final LeetCode_416_canPartition canPartition = new LeetCode_416_canPartition();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(int[] nums, boolean expectedResult) {
        boolean actResult = canPartition.canPartition(nums);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{1, 5, 11, 5}, true),
                arguments(new int[]{1, 2, 3, 5}, false)
        );
    }
}