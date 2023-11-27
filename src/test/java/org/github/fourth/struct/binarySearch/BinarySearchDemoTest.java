package org.github.fourth.struct.binarySearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("二分搜索")
class BinarySearchDemoTest {

    private final BinarySearchDemo binarySearchDemo = new BinarySearchDemo();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(int[] nums, int target, int expectedIndex) {
        int actIndex = binarySearchDemo.binarySearch(nums, target);
        Assertions.assertEquals(expectedIndex, actIndex);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{1, 2, 3, 4, 5}, 5, 4),
                arguments(new int[]{1, 2, 3, 4, 5}, 1, 0),
                arguments(new int[]{1, 2, 3, 4, 5}, 3, 2)
        );
    }


}