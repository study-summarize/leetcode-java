package leetcode;

import org.github.fourth.leetcode.LeetCode_102_levelOrder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.github.fourth.struct.bst.TreeNode;

import java.util.List;
import java.util.stream.Stream;


@DisplayName("XXX测试")
class LeetCode_102_levelOrderTest {
    private final LeetCode_102_levelOrder levelOrder = new LeetCode_102_levelOrder();

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