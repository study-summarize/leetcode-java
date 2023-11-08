package leetcode;

import org.github.fourth.leetcode.LeetCode_547_findCircleNum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName(" 测试")
class Test_547_findCircleNumTest {
    private final LeetCode_547_findCircleNum findCircleNum = new LeetCode_547_findCircleNum();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(int[][] isConnected, int expectedResult) {
        int actResult = findCircleNum.findCircleNum(isConnected);
        Assertions.assertEquals(expectedResult, actResult);

        int actResult2 = findCircleNum.findCircleNumWithDfs(isConnected);
        Assertions.assertEquals(expectedResult, actResult2);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}, 49),
                arguments(new int[]{1, 1}, 1)
        );
    }
}