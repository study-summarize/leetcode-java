package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("323. 无向图中连通分量的数目")
class LeetCode_323_countComponentsTest {
    private final LeetCode_323_countComponents countComponents = new LeetCode_323_countComponents();


    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(int n, int[][] edges, int expectedResult) {
        int actResult = countComponents.countComponents01(n, edges);
        Assertions.assertEquals(expectedResult, actResult);
    }

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void testExample(int n, int[][] edges, int expectedResult) {
        int actResult = countComponents.countComponentsExample(n, edges);
        Assertions.assertEquals(expectedResult, actResult);
    }
    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void testExample02(int n, int[][] edges, int expectedResult) {
        int actResult = countComponents.countComponentsWithDFS(n, edges);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(5, new int[][]{
                        {0, 1},
                        {1, 2},
                        {3, 4}
                }, 2),
                arguments(5, new int[][]{
                        {0, 1},
                        {1, 2},
                        {2, 3},
                        {3, 4}
                }, 1)
        );
    }
}