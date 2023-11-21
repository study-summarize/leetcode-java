package leetcode;

import org.github.fourth.leetcode.LeetCode_503_nextGreaterElements;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("下一个更大元素 II")
public class LeetCode_503_nextGreaterElementsTest {
    private final LeetCode_503_nextGreaterElements nextGreaterElement = new LeetCode_503_nextGreaterElements();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(int[] nums, int[] expectedResult) {
        int[] actResult = nextGreaterElement.nextGreaterElements(Arrays.copyOf(nums, nums.length));
        Assertions.assertEquals(expectedResult.length, actResult.length);
        for (int i = 0; i < expectedResult.length; i++) {
            Assertions.assertEquals(expectedResult[i], actResult[i]);
        }
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{1, 2, 1}, new int[]{2, -1, 2}),
                arguments(new int[]{1, 2, 3, 4, 3}, new int[]{2, 3, 4, -1, 4})
        );
    }
}
