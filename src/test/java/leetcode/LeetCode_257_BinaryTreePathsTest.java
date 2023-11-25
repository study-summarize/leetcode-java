package leetcode;

import org.github.fourth.leetcode.LeetCode_257_BinaryTreePaths;
import org.github.fourth.leetcode.common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("二叉树的所有路径")
class LeetCode_257_BinaryTreePathsTest {
    private final LeetCode_257_BinaryTreePaths binaryTreePaths = new LeetCode_257_BinaryTreePaths();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(TreeNode root, List<String> expectedResult) {
        List<String> actResult = binaryTreePaths.binaryTreePaths(root);
        Assertions.assertArrayEquals(expectedResult.toArray(), actResult.toArray());
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(TreeNode.build(1, 2, 3, null, 5), List.of("1->2->5", "1->3")),
                arguments(TreeNode.build(1), List.of("1"))
        );
    }
}