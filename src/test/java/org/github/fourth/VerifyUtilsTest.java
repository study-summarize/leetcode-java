package org.github.fourth;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("工具测试类")
class VerifyUtilsTest {


    // todo: 功能修复
//    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(List<List<Integer>> actResult, List<List<Integer>> expectedResult) {
        VerifyUtils.assertListInListEquals(actResult, expectedResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(List.of(List.of(3), List.of(20, 9), List.of(15, 7)), List.of(List.of(3), List.of(9, 20), List.of(15, 7)))
        );
    }

}