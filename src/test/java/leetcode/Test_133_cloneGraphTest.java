package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("XXXX")
class Test_133_cloneGraphTest {
    private final Test_133_cloneGraph cloneGraph = new Test_133_cloneGraph();

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
                arguments(new int[]{1,8,6,2,5,4,8,3,7}, 49),
                arguments(new int[]{1,1}, 1)
        );
    }
}