package org.github.fourth.leetcode;

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
                arguments(2, new int[][]{
                        {1, 0}
                }, new int[]{0, 1}),
                arguments(4, new int[][]{
                        {1, 0},
                        {2, 0},
                        {3, 1},
                        {3, 2}
                }, new int[]{0, 2, 1, 3}),
                arguments(1, new int[0][0], new int[]{0})
        );
    }
}