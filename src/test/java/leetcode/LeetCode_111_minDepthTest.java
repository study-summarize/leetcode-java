package leetcode;

import org.github.fourth.leetcode.LeetCode_111_minDepth;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.github.fourth.struct.bst.TreeNode;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("XXX")
class LeetCode_111_minDepthTest {
    private final LeetCode_111_minDepth minDepth = new LeetCode_111_minDepth();

//    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(TreeNode root, int expectedResult) {

        int actResult = minDepth.minDepth(root);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{1,8,6,2,5,4,8,3,7}, 49),
                arguments(new int[]{1,1}, 1)
        );
    }
}