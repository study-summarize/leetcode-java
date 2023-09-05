import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("三数之和测试")
public class ThreeSumTest {

    private final ThreeSum threeSum = new ThreeSum();

    @DisplayName("三数之和测试")
    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(int[] nums, int target, int[] expectedResults) {
        Arrays.sort(expectedResults);

        int[] actResult1 = threeSum.threeSum(nums, target);
        Arrays.sort(actResult1);
        Assertions.assertEquals(expectedResults.length, actResult1.length);
        Assertions.assertArrayEquals(expectedResults, actResult1);

        int[] actResult2 = threeSum.threeSumV2(nums, target);
        Arrays.sort(actResult2);
        Assertions.assertEquals(expectedResults.length, actResult2.length);
        Assertions.assertArrayEquals(expectedResults, actResult2);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{-1, 0, 1, 2, -4}, 0,  new int[]{-1, 0, 1}),
                arguments(new int[]{-1, 0, 1, 2, -4}, 3,  new int[]{0, 1, 2}),
                arguments(new int[]{-1, 0, 1, 2, -4}, -5,  new int[]{0, -1, -4})
        );
    }

}
