package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.Function;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("搜索二维矩阵 II")
public class LeetCode_240_searchMatrixTest {
    private final LeetCode_240_searchMatrix leetCode240SearchMatrix = new LeetCode_240_searchMatrix();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test00(int[][] matrix, int target, boolean expectedResult) {
        commonTest(expectedResult, x -> x.searchMatrix00(matrix, target));
    }

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(int[][] matrix, int target, boolean expectedResult) {
        commonTest(expectedResult, x -> x.searchMatrix01(matrix, target));
    }

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test02(int[][] matrix, int target, boolean expectedResult) {
        commonTest(expectedResult, x -> x.searchMatrix02(matrix, target));
    }

    private void commonTest(boolean expectedResult, Function<LeetCode_240_searchMatrix, Boolean> function) {
        Boolean actResult = function.apply(leetCode240SearchMatrix);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[][]{
                        {1, 4, 7, 11, 15},
                        {2, 5, 8, 12, 19},
                        {3, 6, 9, 16, 22},
                        {10, 13, 14, 17, 24},
                        {18, 21, 23, 26, 30}
                }, 5, true),
                arguments(new int[][]{
                        {1, 4, 7, 11, 15},
                        {2, 5, 8, 12, 19},
                        {3, 6, 9, 16, 22},
                        {10, 13, 14, 17, 24},
                        {18, 21, 23, 26, 30}
                }, 20, false)
        );
    }

}
