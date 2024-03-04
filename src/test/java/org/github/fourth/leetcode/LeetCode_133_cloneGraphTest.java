package org.github.fourth.leetcode;

import org.github.fourth.leetcode.common.graph.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


@DisplayName("克隆图")
class LeetCode_133_cloneGraphTest {
    private final LeetCode_133_cloneGraph cloneGraph = new LeetCode_133_cloneGraph();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(int[][] graph, int nodeNumbers) {
        Node actResult = cloneGraph.cloneGraph01(Node.build(graph));
        Assertions.assertArrayEquals(graph, actResult.convert(nodeNumbers));
    }

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void testExample01(int[][] graph, int nodeNumbers) {
        Node actResult = cloneGraph.cloneGraphExample01(Node.build(graph));
        Assertions.assertArrayEquals(graph, actResult.convert(nodeNumbers));
    }

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void testUseDFSExample02(int[][] graph, int nodeNumbers) {
        Node actResult = cloneGraph.cloneGraphWithDfsExample02(Node.build(graph));
        Assertions.assertArrayEquals(graph, actResult.convert(nodeNumbers));
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                Arguments.arguments(new int[][]{
                        {1, 1, 0, 1},
                        {1, 1, 1, 0},
                        {0, 1, 1, 1},
                        {1, 0, 1, 1}
                }, 4),
                Arguments.arguments(new int[][]{
                        {1},
                }, 1),
                Arguments.arguments(new int[][]{}, 0),
                Arguments.arguments(new int[][]{
                        {1, 1},
                        {1, 1}
                }, 2)
        );
    }
}