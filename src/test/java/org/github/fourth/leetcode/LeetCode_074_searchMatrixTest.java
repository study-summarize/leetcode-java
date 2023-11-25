package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("搜索二维矩阵")
public class LeetCode_074_searchMatrixTest {

    private final LeetCode_074_searchMatrix leetCode074SearchMatrix = new LeetCode_074_searchMatrix();


    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(int[][] matrix, int target, boolean expectedResult) {
        boolean actResult = leetCode074SearchMatrix.searchMatrix(matrix, target);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[][]{
                        {1, 3, 5, 7},
                        {10, 11, 16, 20},
                        {23, 30, 34, 60}
                }, 3, true),
                arguments(new int[][]{
                        {1, 3, 5, 7},
                        {10, 11, 16, 20},
                        {23, 30, 34, 60}
                }, 13, false)
        );
    }

}
