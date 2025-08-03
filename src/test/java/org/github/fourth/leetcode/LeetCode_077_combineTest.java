package org.github.fourth.leetcode;

import org.github.fourth.VerifyUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("组合")
class LeetCode_077_combineTest {
    private static final LeetCode_077_combine instance = new LeetCode_077_combine();

    @ParameterizedTest
    @MethodSource(value = "generateRightCase")
    public void test(int n, int k, List<List<Integer>> expectedResult) {
        List<List<Integer>> actResult = instance.combine(n, k);
        VerifyUtils.assertListInListEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(4, 2, List.of(
                        List.of(1, 2),
                        List.of(1, 3),
                        List.of(1, 4),
                        List.of(2, 3),
                        List.of(2, 4),
                        List.of(3, 4)
                ))
        );
    }

}