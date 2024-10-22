package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("56. 合并区间")
class LeetCode_056_mergeTest {
    private final LeetCode_056_merge instance = new LeetCode_056_merge();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(int[][] intervals, int[][] expectedResult) {
        int[][] actResult = instance.merge(intervals);

    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(
                        new int[][]{
                                {1, 3},
                                {2, 6},
                                {8, 10},
                                {15, 18}},
                        new int[][]{
                                {1, 6},
                                {8, 10},
                                {15, 18}
                        }),
                arguments(
                        new int[][]{
                                {1, 4},
                                {4, 5}},
                        new int[][]{
                                {1, 5},
                        })
        );
    }

}