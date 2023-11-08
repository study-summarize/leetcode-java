package leetcode;

import org.github.fourth.leetcode.LeetCode_200_numIslands;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName(" 测试")
class Test_200_numIslandsTest {
    private final LeetCode_200_numIslands numIslands = new LeetCode_200_numIslands();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(char[][] grid,int expectedResult) {
        int actResult1 = numIslands.numIslands(grid);
        Assertions.assertEquals(expectedResult, actResult1);

        int actResult2 = numIslands.numIslandsWithDfs(grid);
        Assertions.assertEquals(expectedResult, actResult2);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{1,8,6,2,5,4,8,3,7}, 49),
                arguments(new int[]{1,1}, 1)
        );
    }
}