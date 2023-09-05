package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("XXXX")
class Test_490_hasPathTest {
    private final Test_490_hasPath hasPath = new Test_490_hasPath();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(int[][] maze, int[] start, int[] destination, boolean expectedResult) {
        boolean actResult = hasPath.hasPath(maze, start, destination);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}, 49),
                arguments(new int[]{1, 1}, 1)
        );
    }
}