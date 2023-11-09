package leetcode;

import org.github.fourth.leetcode.LeetCode_113_pathSum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.github.fourth.struct.bst.TreeNode;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("XXX")
class LeetCode_113_pathSumTest {
    private final LeetCode_113_pathSum pathSum = new LeetCode_113_pathSum();
//    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(TreeNode root, int targetSum, List<List<Integer>> expectedResult) {
        List<List<Integer>> actResult = pathSum.pathSum(root, targetSum);
        Assertions.assertArrayEquals(expectedResult.toArray(), actResult.toArray());
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{1,8,6,2,5,4,8,3,7}, 49),
                arguments(new int[]{1,1}, 1)
        );
    }
}