package leetcode;

import org.github.fourth.leetcode.LeetCode_103_zigzagLevelOrder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.github.fourth.struct.bst.TreeNode;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;


@DisplayName("XXX")
class Test_103_zigzagLevelOrderTest {
    private final LeetCode_103_zigzagLevelOrder zigzagLevelOrder = new LeetCode_103_zigzagLevelOrder();
//    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(TreeNode root, List<List<Integer>> expectedResult) {
        List<List<Integer>> actResult = zigzagLevelOrder.zigzagLevelOrder(root);
        Assertions.assertArrayEquals(expectedResult.toArray(), actResult.toArray());
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{1,8,6,2,5,4,8,3,7}, 49),
                arguments(new int[]{1,1}, 1)
        );
    }

}