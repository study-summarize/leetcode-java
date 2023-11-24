package org.github.fourth.leetcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("天际线问题")
class LeetCode_218_getSkylineTest {
    private final LeetCode_218_getSkyline leetCode218GetSkyline = new LeetCode_218_getSkyline();


    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(int[][] buildings, List<List<Integer>> expectedResult) {
        List<List<Integer>> actResult = leetCode218GetSkyline.getSkyline(buildings);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[][]{
                        {2, 9, 10},
                        {3, 7, 15},
                        {5, 12, 12},
                        {15, 20, 10},
                        {19, 24, 8}
                }, Arrays.asList(Arrays.asList(2, 10), Arrays.asList(3, 15), Arrays.asList(7, 12), Arrays.asList(12, 0), Arrays.asList(15, 10), Arrays.asList(20, 8), Arrays.asList(24, 0))),
                arguments(new int[][]{
                        {0, 2, 3},
                        {2, 5, 3}
                }, Arrays.asList(Arrays.asList(0, 3), Arrays.asList(5, 0)))
        );
    }
}