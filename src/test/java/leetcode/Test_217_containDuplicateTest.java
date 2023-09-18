package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("存在重复元素 测试")
class Test_217_containDuplicateTest {
    private final Test_217_containDuplicate containDuplicate = new Test_217_containDuplicate();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(int[] nums, boolean expectedResult) {

        boolean actResult = containDuplicate.containsDuplicate(nums);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}, 49),
                arguments(new int[]{1, 1}, 1)
        );
    }
}