package leetcode;

import org.github.fourth.leetcode.LeetCode_210_findOrder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("课程表 II")
class LeetCode_210_findOrderTest {
    private final LeetCode_210_findOrder findOrder = new LeetCode_210_findOrder();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(int numCourses, int[][] prerequisites, int[] expectedResult) {
        int[] actResult = findOrder.findOrder(numCourses, prerequisites);
        Assertions.assertArrayEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}, 49),
                arguments(new int[]{1, 1}, 1)
        );
    }
}