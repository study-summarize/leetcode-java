package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("课程表")
class LeetCode_207_canFinishTest {
    private final LeetCode_207_canFinish canFinish = new LeetCode_207_canFinish();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(int numCourses, int[][] prerequisites, boolean expectedResult) {
        boolean actResult = canFinish.canFinish01(numCourses, prerequisites);
        Assertions.assertEquals(expectedResult, actResult);
    }
    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void testExample(int numCourses, int[][] prerequisites, boolean expectedResult) {
        boolean actResult = canFinish.canFinishExample(numCourses, prerequisites);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(1, new int[][]{{}}, true),
                arguments(2, new int[][]{{1, 0}}, true),
                arguments(2, new int[][]{{1, 0}, {0, 1}}, false)
        );
    }
}