package org.github.fourth.leetcode;


import org.github.fourth.VerifyUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("计算右侧小于当前元素的个数")
class LeetCode_315_countSmallerTest {
    private final LeetCode_315_countSmaller testInstance = new LeetCode_315_countSmaller();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(int[] record, List<Integer> expectedResult) {
        List<Integer> actResult = testInstance.countSmaller01(record);
        VerifyUtils.assertListEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{5, 2, 6, 1}, Arrays.asList(2, 1, 1, 0))
        );
    }
}