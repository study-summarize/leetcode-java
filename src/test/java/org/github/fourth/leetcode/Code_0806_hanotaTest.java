package org.github.fourth.leetcode;

import org.github.fourth.leetcode.code.Code_0806_hanota;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("汉诺塔问题")
public class Code_0806_hanotaTest {

    private final Code_0806_hanota code0806Hanota = new Code_0806_hanota();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(List<Integer> A, List<Integer> B, List<Integer> C, List<Integer> expectedResult) {
        code0806Hanota.hanota(A, B, C);
        Assertions.assertArrayEquals(expectedResult.toArray(), C.toArray());
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(Arrays.asList(2, 1, 0), new ArrayList<>(), new ArrayList<>(), Arrays.asList(2, 1, 0)),
                arguments(Arrays.asList(1, 0), new ArrayList<>(), new ArrayList<>(), Arrays.asList(1, 0))
        );
    }
}
