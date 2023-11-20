package leetcode;

import org.github.fourth.leetcode.LeetCode_304_NumMatrix;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("二维区域和检索 - 矩阵不可变")
public class LeetCode_304_NumMatrixTest {

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(int[][] matrix, int row1, int col1, int row2, int col2, int expectedResults) {
        int actResult01 = new LeetCode_304_NumMatrix(Arrays.copyOf(matrix, matrix.length))
                .sumRegion(row1, col1, row2, col2);
        int actResult = new LeetCode_304_NumMatrix(Arrays.copyOf(matrix, matrix.length))
                .sumRegionExample(row1, col1, row2, col2);

        Assertions.assertEquals(expectedResults, actResult);
        Assertions.assertEquals(expectedResults, actResult01);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[][]{
                        new int[]{3, 0, 1, 4, 2},
                        new int[]{5, 6, 3, 2, 1},
                        new int[]{1, 2, 0, 1, 5},
                        new int[]{4, 1, 0, 1, 7},
                        new int[]{1, 0, 3, 0, 5}
                }, 2, 1, 4, 3, 8),
                arguments(new int[][]{
                        new int[]{3, 0, 1, 4, 2},
                        new int[]{5, 6, 3, 2, 1},
                        new int[]{1, 2, 0, 1, 5},
                        new int[]{4, 1, 0, 1, 7},
                        new int[]{1, 0, 3, 0, 5}
                }, 1, 1, 2, 2, 11),
                arguments(new int[][]{
                        new int[]{3, 0, 1, 4, 2},
                        new int[]{5, 6, 3, 2, 1},
                        new int[]{1, 2, 0, 1, 5},
                        new int[]{4, 1, 0, 1, 7},
                        new int[]{1, 0, 3, 0, 5}
                }, 1, 2, 2, 4, 12)
        );
    }
}
