package org.github.fourth.leetcode;


import org.github.fourth.ListNodeVerifyUtil;
import org.github.fourth.leetcode.common.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class LeetCode_085_maximalRectangleTest {

    private final LeetCode_085_maximalRectangle instance = new LeetCode_085_maximalRectangle();


    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(char[][] matrix, int expectedResult) {
        int actResult = instance.maximalRectangle(matrix);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new char[][]{
                        {'1', '0', '1', '0', '0'},
                        {'1', '0', '1', '1', '1'},
                        {'1', '1', '1', '1', '1'},
                        {'1', '0', '0', '1', '0'}
                }, 6),
                arguments(new char[][]{
                        {'0'}
                }, 0),
                arguments(new char[][]{
                        {'1'}
                }, 1)

        );
    }

}