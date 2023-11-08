package leetcode;

import org.github.fourth.leetcode.LeetCode_001_twoSum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("俩数之和测试数据")
public class LeetCode_001_twoSumTest {

    private final LeetCode_001_twoSum test001TwoSum = new LeetCode_001_twoSum();


    @DisplayName("暴力解法")
    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(int[] nums, int target, int[] expectedResults) {
        int[] actResult = test001TwoSum.twoSum01(nums, target);
        Assertions.assertEquals(expectedResults.length, actResult.length);
        Assertions.assertEquals(2, actResult.length);
        if (expectedResults[0] == actResult[0]) {
            Assertions.assertEquals(expectedResults[1], actResult[1]);
        } else {
            Assertions.assertEquals(expectedResults[0], actResult[1]);
            Assertions.assertEquals(expectedResults[1], actResult[0]);
        }
    }

    @DisplayName("排序+双指针")
    @ParameterizedTest
    @MethodSource("generateRight02Case")
    public void two02(int[] nums, int target, int[] expectedResults) {
        int[] actResult = test001TwoSum.twoSum02(nums, target);
        Assertions.assertEquals(expectedResults.length, actResult.length);
        Assertions.assertEquals(2, actResult.length);
        if (expectedResults[0] == actResult[0]) {
            Assertions.assertEquals(expectedResults[1], actResult[1]);
        } else {
            Assertions.assertEquals(expectedResults[0], actResult[1]);
            Assertions.assertEquals(expectedResults[1], actResult[0]);
        }
    }

    @DisplayName("哈希表")
    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test03(int[] nums, int target, int[] expectedResults) {
        int[] actResult = test001TwoSum.twoSum03(nums, target);
        Assertions.assertEquals(expectedResults.length, actResult.length);
        Assertions.assertEquals(2, actResult.length);
        if (expectedResults[0] == actResult[0]) {
            Assertions.assertEquals(expectedResults[1], actResult[1]);
        } else {
            Assertions.assertEquals(expectedResults[0], actResult[1]);
            Assertions.assertEquals(expectedResults[1], actResult[0]);
        }
    }


    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{2, 7, 11, 15}, 9, new int[]{0, 1}),
                arguments(new int[]{2, 7, 11, 15}, 13, new int[]{0, 2}),
                arguments(new int[]{2, 7, 11, 15}, 17, new int[]{0, 3}),
                arguments(new int[]{2, 7, 11, 15}, 26, new int[]{2, 3}),
                arguments(new int[]{3, 3}, 6, new int[]{0, 1}),
                arguments(new int[]{3, 2, 4}, 6, new int[]{1, 2})
        );
    }

    public static Stream<Arguments> generateRight02Case() {
        return Stream.of(
                arguments(new int[]{2, 7, 11, 15}, 9, new int[]{2, 7}),
                arguments(new int[]{2, 7, 11, 15}, 13, new int[]{2, 11}),
                arguments(new int[]{2, 7, 11, 15}, 17, new int[]{2, 15}),
                arguments(new int[]{2, 7, 11, 15}, 26, new int[]{11, 15}),
                arguments(new int[]{3, 3}, 6, new int[]{3, 3}),
                arguments(new int[]{3, 2, 4}, 6, new int[]{2, 4})
        );
    }
}
