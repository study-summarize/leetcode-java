package org.github.fourth.leetcode;

import org.github.fourth.VerifyUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("划分字母区间")
class LeetCode_763_partitionLabelsTest {
    private static final LeetCode_763_partitionLabels instance = new LeetCode_763_partitionLabels();

    @ParameterizedTest
    @MethodSource(value = "generateRightCase")
    public void test(String s, List<Integer> expectedResult) {
        List<Integer> actResult = instance.partitionLabels(s);
        VerifyUtils.assertListEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments("ababcbacadefegdehijhklij", List.of(9, 7, 8)),
                arguments("eccbbbbdec", List.of(10))
        );
    }


}