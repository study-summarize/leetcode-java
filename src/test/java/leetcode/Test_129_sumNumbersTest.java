package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import struct.bst.TreeNode;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("XXXX")
class Test_129_sumNumbersTest {
    private final Test_129_sumNumbers sumNumbers = new Test_129_sumNumbers();
    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(TreeNode root, int expectedResult) {

        int actResult = sumNumbers.sumNumbers(root);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{1,8,6,2,5,4,8,3,7}, 49),
                arguments(new int[]{1,1}, 1)
        );
    }
}