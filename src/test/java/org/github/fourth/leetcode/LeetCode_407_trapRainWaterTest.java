package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("接雨水 II")
class LeetCode_407_trapRainWaterTest {
    private final LeetCode_407_trapRainWater leetCode407TrapRainWater = new LeetCode_407_trapRainWater();


//    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(int[][] heightMap, int expectedResult) {
        int actResult = leetCode407TrapRainWater.trapRainWater01(heightMap);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[][]{
                        {1, 4, 3, 1, 3, 2},
                        {3, 2, 1, 3, 2, 4},
                        {2, 3, 3, 2, 3, 1}
                }, 4),
                arguments(new int[][]{
                        {3, 3, 3, 3, 3},
                        {3, 2, 2, 2, 3},
                        {3, 2, 1, 2, 3},
                        {3, 2, 2, 2, 3},
                        {3, 3, 3, 3, 3}
                }, 10)
        );
    }


}