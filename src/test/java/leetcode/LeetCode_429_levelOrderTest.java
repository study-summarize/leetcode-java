package leetcode;

import org.github.fourth.leetcode.LeetCode_429_levelOrder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("N 叉树的层序遍历")
class LeetCode_429_levelOrderTest {
    private final LeetCode_429_levelOrder levelOrder = new LeetCode_429_levelOrder();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(LeetCode_429_levelOrder.Node root, List<List<Integer>> expectedResult) {
        List<List<Integer>> actResult = levelOrder.levelOrder(root);
        Assertions.assertArrayEquals(expectedResult.toArray(), actResult.toArray());
    }

    // todo: 待修改
    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
        );
    }
}