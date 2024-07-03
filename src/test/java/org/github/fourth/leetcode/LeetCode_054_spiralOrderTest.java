package org.github.fourth.leetcode;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("54. 螺旋矩阵")
class LeetCode_054_spiralOrderTest {
    private final LeetCode_054_spiralOrder instance = new LeetCode_054_spiralOrder();


    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(int[][] matrix, List<Integer> expectedResult) {
        List<Integer> actResult = instance.spiralOrder(matrix);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(
                        new int[][]{
                                {1, 2, 3},
                                {4, 5, 6},
                                {7, 8, 9}},
                        Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5)
                ),
                arguments(
                        new int[][]{
                                {1, 2, 3, 4},
                                {5, 6, 7, 8}},
                        Arrays.asList(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7)
                ));
    }
}