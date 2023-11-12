package leetcode;

import org.github.fourth.leetcode.LeetCode_084_largestRectangleArea;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("柱状图中最大的矩形")
public class LeetCode_084_largestRectangleAreaTest {

    private final LeetCode_084_largestRectangleArea largestRectangleArea = new LeetCode_084_largestRectangleArea();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(int[] heights, int expectedResult) {
        int actResult = largestRectangleArea.largestRectangleArea(Arrays.copyOf(heights, heights.length));
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{2, 1, 5, 6, 2, 3}, 10),
                arguments(new int[]{2, 4}, 4)
        );
    }

}
