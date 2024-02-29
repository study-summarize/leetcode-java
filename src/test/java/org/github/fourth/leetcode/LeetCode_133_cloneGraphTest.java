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
    public void test01(Node node, Node expectedResult) {
        Node actResult = cloneGraph.cloneGraph01(node);
        // todo: 如何比较两个图是否相等？
        Assertions.assertEquals(expectedResult, actResult);
    }

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void testExample01(Node node, Node expectedResult) {
        Node actResult = cloneGraph.cloneGraphExample01(node);
        // todo: 如何比较两个图是否相等？
        Assertions.assertEquals(expectedResult, actResult);
    }

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void testUseDFSExample02(Node node, Node expectedResult) {
        Node actResult = cloneGraph.cloneGraphWithDfsExample02(node);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
        );
    }
}