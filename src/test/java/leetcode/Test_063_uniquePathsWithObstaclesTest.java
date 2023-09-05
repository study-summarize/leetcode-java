package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


@DisplayName("XXX测试")
class Test_063_uniquePathsWithObstaclesTest {

    private final Test_063_uniquePathsWithObstacles uniquePathsWithObstacles = new Test_063_uniquePathsWithObstacles();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(int[][] obstacleGrid, int expectedResult) {

        int actResult = uniquePathsWithObstacles.uniquePathsWithObstacles(obstacleGrid);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
        );
    }
}