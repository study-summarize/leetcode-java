package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("有效三角形的个数")
class LeetCode_611_triangleNumberTest {
    private final LeetCode_611_triangleNumber triangleNumber = new LeetCode_611_triangleNumber();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(int[] nums, int expectedResult) {
        int actResult = triangleNumber.triangleNumber(nums);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{2, 2, 3, 4}, 3),
                arguments(new int[]{4, 2, 3, 4}, 4)
        );
    }
}