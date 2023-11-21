import org.github.fourth.NextGreaterNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("下一个更大元素")
public class NextGreaterNumberTest {
    @ParameterizedTest
    @MethodSource("findRightNextGreaterCase")
    public void test01(int[] nums, int[] expectedResults) {
        int[] actResult1 = NextGreaterNumber.findRightNextGreater(Arrays.copyOf(nums, nums.length));
        Assertions.assertArrayEquals(expectedResults, actResult1);
    }
    @ParameterizedTest
    @MethodSource("findRightNextSmallerCase")
    public void test02(int[] nums, int[] expectedResults) {
        int[] actResult1 = NextGreaterNumber.findRightNextSmaller(Arrays.copyOf(nums, nums.length));
        Assertions.assertArrayEquals(expectedResults, actResult1);
    }
    @ParameterizedTest
    @MethodSource("findLeftNextGreaterCase")
    public void test03(int[] nums, int[] expectedResults) {
        int[] actResult1 = NextGreaterNumber.findLeftNextGreater(Arrays.copyOf(nums, nums.length));
        Assertions.assertArrayEquals(expectedResults, actResult1);
    }
    @ParameterizedTest
    @MethodSource("findLeftNextSmallerCase")
    public void test04(int[] nums, int[] expectedResults) {
        int[] actResult1 = NextGreaterNumber.findLeftNextSmaller(Arrays.copyOf(nums, nums.length));
        Assertions.assertArrayEquals(expectedResults, actResult1);
    }

    public static Stream<Arguments> findRightNextGreaterCase() {
        return Stream.of(
                arguments(new int[]{1, 5, 3, 6, 4, 8, 9, 10}, new int[]{5, 6, 6, 8, 8, 9, 10, -1}),
                arguments(new int[]{2, 3, 4, 1, 5, 3, 4}, new int[]{3, 4, 5, 5, -1, 4, -1}),
                arguments(new int[]{8, 2, 5, 4, 3, 9, 7, 2, 5}, new int[]{9, 5, 9, 9, 9, -1, -1, 5, -1})
        );
    }

    public static Stream<Arguments> findRightNextSmallerCase() {
        return Stream.of(
                arguments(new int[]{2, 3, 4, 1, 5, 3, 4}, new int[]{1, 1, 1, -1, 3, -1, -1})
        );
    }

    public static Stream<Arguments> findLeftNextGreaterCase() {
        return Stream.of(
                arguments(new int[]{2, 3, 4, 1, 5, 3, 4}, new int[]{-1, -1, -1, 4, -1, 5, 5})
        );
    }

    public static Stream<Arguments> findLeftNextSmallerCase() {
        return Stream.of(
                arguments(new int[]{2, 3, 4, 1, 5, 3, 4}, new int[]{-1, 2, 3, -1, 1, 1, 3})
        );
    }

}
