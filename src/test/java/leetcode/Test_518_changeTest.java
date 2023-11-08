package leetcode;

import org.github.fourth.leetcode.LeetCode_518_change;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName(" 测试")
class Test_518_changeTest {
    private final LeetCode_518_change change = new LeetCode_518_change();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(int amount, int[] coins, int expectedResult) {
        int actResult = this.change.change(amount, coins);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}, 49),
                arguments(new int[]{1, 1}, 1)
        );
    }
}