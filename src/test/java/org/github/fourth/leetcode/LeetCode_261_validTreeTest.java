package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("261. 以图判树")
class LeetCode_261_validTreeTest {
    private final LeetCode_261_validTree validTree = new LeetCode_261_validTree();


    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(int n, int[][] edges, boolean expectedResult) {
        boolean actResult = validTree.validTree01(n, edges);
        Assertions.assertEquals(expectedResult, actResult);
    }

//    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void testExample01(int n, int[][] edges, boolean expectedResult) {
        boolean actResult = validTree.validTreeBfsExample(n, edges);
        Assertions.assertEquals(expectedResult, actResult);
    }

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void testExample02(int n, int[][] edges, boolean expectedResult) {
        boolean actResult02 = validTree.validTreeWithDfsExample(n, edges);
        Assertions.assertEquals(expectedResult, actResult02);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(5, new int[][]{
                        {0, 1},
                        {0, 2},
                        {0, 3},
                        {1, 4}
                }, true),
                arguments(1, new int[][]{
                }, true),
                arguments(5, new int[][]{
                        {0, 1},
                        {1, 2},
                        {2, 3},
                        {1, 3},
                        {1, 4}
                }, false)
        );
    }
}