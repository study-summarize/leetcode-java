package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("XXXX")
class Test_265_minCostIITest {
    private final Test_265_minCostII minCostII = new Test_265_minCostII();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(int[][] costs, int expectedResult) {
        int actResult1 = minCostII.minCostII(costs);
        Assertions.assertEquals(expectedResult, actResult1);

        int actResult2 = minCostII.minCostIIRefine(costs);
        Assertions.assertEquals(expectedResult, actResult2);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}, 49),
                arguments(new int[]{1, 1}, 1)
        );
    }
}