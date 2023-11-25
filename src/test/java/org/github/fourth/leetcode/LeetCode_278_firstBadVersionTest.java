package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("第一个错误的版本")
public class LeetCode_278_firstBadVersionTest {

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(int n, int expectedResult) {
        LeetCode_278_firstBadVersion leetCode278FirstBadVersion = new LeetCode_278_firstBadVersion(expectedResult);
        int actResult = leetCode278FirstBadVersion.firstBadVersion(n);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(5, 4), // bad = 4
                arguments(1, 1)  // bad = 1
        );
    }

}
