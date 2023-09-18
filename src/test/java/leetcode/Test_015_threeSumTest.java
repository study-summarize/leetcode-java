package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("三数之和测试数据")
public class Test_015_threeSumTest {

    private static final Test_015_threeSum test015ThreeSum = new Test_015_threeSum();

    @DisplayName("暴力解法")
    @ParameterizedTest
    @MethodSource("generateRight01Case")
    public void test01(int[] nums, int target, int[] expectedResults) {
        int[] actResult = test015ThreeSum.threeSum01(nums, target);
        Arrays.sort(expectedResults);
        Arrays.sort(actResult);
        Assertions.assertEquals(expectedResults.length, actResult.length);
        for (int i = 0; i < expectedResults.length; i++) {
            Assertions.assertEquals(expectedResults[i], actResult[i]);
        }
    }

    @DisplayName("暴力解法")
    @ParameterizedTest
    @MethodSource("generateRight02Case")
    public void test02(int[] nums, List<Integer> expectedResults) {
        List<List<Integer>> actResultList = test015ThreeSum.threeSum02(nums);
        Assertions.assertEquals(1, actResultList.size());
        expectedResults.sort(Integer::compareTo);
        actResultList.get(0).sort(Integer::compareTo);

        Assertions.assertEquals(expectedResults.size(), actResultList.get(0).size());
        for (int i = 0; i < expectedResults.size(); i++) {
            Assertions.assertEquals(expectedResults.get(i), actResultList.get(0).get(i));
        }
    }

    public static Stream<Arguments> generateRight02Case() {
        return Stream.of(
                arguments(new int[]{-1, 0, 1, 2, -4}, Arrays.asList(-1, 0, 1)),
                arguments(new int[]{3, 2, -5}, Arrays.asList(3, 2, -5))
        );
    }

    public static Stream<Arguments> generateRight01Case() {
        return Stream.of(
                arguments(new int[]{-1, 0, 1, 2, -4}, 0, new int[]{-1, 0, 1}),
                arguments(new int[]{2, 7, 11, 15}, 20, new int[]{2, 7, 11}),
                arguments(new int[]{2, 7, 11, 15}, 28, new int[]{2, 11, 15}),
                arguments(new int[]{2, 7, 11, 15}, 33, new int[]{7, 11, 15}),
                arguments(new int[]{3, 2, 4}, 9, new int[]{3, 2, 4})
        );
    }

}
