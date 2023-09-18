package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName(" 测试")
class Test_429_levelOrderTest {
    private final Test_429_levelOrder levelOrder = new Test_429_levelOrder();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(Test_429_levelOrder.Node root, List<List<Integer>> expectedResult) {
        List<List<Integer>> actResult = levelOrder.levelOrder(root);
        Assertions.assertArrayEquals(expectedResult.toArray(), actResult.toArray());
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}, 49),
                arguments(new int[]{1, 1}, 1)
        );
    }
}