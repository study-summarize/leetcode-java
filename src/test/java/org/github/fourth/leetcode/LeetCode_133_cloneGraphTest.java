package org.github.fourth.leetcode;

import org.github.fourth.leetcode.LeetCode_133_cloneGraph.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


@DisplayName("克隆图")
class LeetCode_133_cloneGraphTest {
    private final LeetCode_133_cloneGraph cloneGraph = new LeetCode_133_cloneGraph();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(Node node, Node expectedResult) {
        Node actResult = cloneGraph.cloneGraph(node);
        // todo: 如何比较两个图是否相等？
        Assertions.assertEquals(expectedResult, actResult);
    }

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void testUseDFS(Node node, Node expectedResult) {
        Node actResult = cloneGraph.cloneGraphWithDfs(node);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
        );
    }
}