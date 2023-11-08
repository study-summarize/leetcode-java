package leetcode;

import org.github.fourth.leetcode.LeetCode_354_maxEnvelopes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName(" 测试")
class Test_354_maxEnvelopesTest {
    private final LeetCode_354_maxEnvelopes maxEnvelopes = new LeetCode_354_maxEnvelopes();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(int[][] envelopes, int expectedResult) {

        int actResult = maxEnvelopes.maxEnvelopes(envelopes);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}, 49),
                arguments(new int[]{1, 1}, 1)
        );
    }
}