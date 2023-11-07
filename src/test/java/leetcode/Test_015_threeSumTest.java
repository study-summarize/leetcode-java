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

    @DisplayName("原版题目解法")
    @ParameterizedTest
    @MethodSource("generateOriginRightCase")
    public void testOrigin(int[] nums, List<Integer> expectedResults) {
        expectedResults.sort(Integer::compareTo);

        List<List<Integer>> actResultList = test015ThreeSum.threeSumExample(Arrays.copyOf(nums, nums.length));
        List<List<Integer>> actResultList01 = test015ThreeSum.threeSum01(Arrays.copyOf(nums, nums.length));
        Assertions.assertEquals(1, actResultList.size());
        Assertions.assertEquals(1, actResultList01.size());
        actResultList.forEach(x -> x.sort(Integer::compareTo));
        actResultList01.forEach(x -> x.sort(Integer::compareTo));

        Assertions.assertEquals(expectedResults.size(), actResultList.get(0).size());
        Assertions.assertEquals(expectedResults.size(), actResultList01.get(0).size());
        for (int i = 0; i < expectedResults.size(); i++) {
            Assertions.assertEquals(expectedResults.get(i), actResultList.get(0).get(i));
            Assertions.assertEquals(expectedResults.get(i), actResultList01.get(0).get(i));
        }
    }


    @DisplayName("变版题目解法")
    @ParameterizedTest
    @MethodSource("generateChangeRightCase")
    public void testChange(int[] nums, int target, int[] expectedResults) {
        int[] actResult1 = test015ThreeSum.threeSumChange01(nums, target);
        int[] actResult2 = test015ThreeSum.threeSumChange02(nums, target);
        Arrays.sort(expectedResults);
        Arrays.sort(actResult1);
        Arrays.sort(actResult2);
        Assertions.assertEquals(expectedResults.length, actResult1.length);
        for (int i = 0; i < expectedResults.length; i++) {
            Assertions.assertEquals(expectedResults[i], actResult1[i]);
            Assertions.assertEquals(expectedResults[i], actResult2[i]);
        }
    }

    public static Stream<Arguments> generateOriginRightCase() {
        return Stream.of(
                arguments(new int[]{-1, 0, 1, 2, -4}, Arrays.asList(-1, 0, 1)),
                arguments(new int[]{0, 0, 0, 0, 0}, Arrays.asList(0, 0, 0)),
                arguments(new int[]{3, 2, -5}, Arrays.asList(3, 2, -5))
        );
    }

    public static Stream<Arguments> generateChangeRightCase() {
        return Stream.of(
                arguments(new int[]{-1, 0, 1, 2, -4}, 0, new int[]{-1, 0, 1}),
                arguments(new int[]{2, 7, 11, 15}, 20, new int[]{2, 7, 11}),
                arguments(new int[]{2, 7, 11, 15}, 28, new int[]{2, 11, 15}),
                arguments(new int[]{2, 7, 11, 15}, 33, new int[]{7, 11, 15}),
                arguments(new int[]{3, 2, 4}, 9, new int[]{3, 2, 4})
        );
    }

}
