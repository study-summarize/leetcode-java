package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import struct.bst.TreeNode;

import java.util.List;
import java.util.stream.Stream;


@DisplayName("XXX测试")
class Test_102_levelOrderTest {
    private final Test_102_levelOrder levelOrder = new Test_102_levelOrder();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(TreeNode root, List<List<Integer>> expectedResult) {
        List<List<Integer>> actResult = levelOrder.levelOrder(root);
        Assertions.assertArrayEquals(expectedResult.toArray(), actResult.toArray());
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
        );
    }
}