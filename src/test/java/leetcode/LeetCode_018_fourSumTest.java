package leetcode;

import org.github.fourth.leetcode.LeetCode_018_fourSum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("四数之和")
public class LeetCode_018_fourSumTest {

    private static final LeetCode_018_fourSum test018FourSum = new LeetCode_018_fourSum();

//    @ParameterizedTest
    @MethodSource("generateOriginRightCase")
    public void testOrigin(int[] nums, int target, List<List<Integer>> expectedResults) {
        expectedResults.forEach(x -> x.sort(Integer::compareTo));

        List<List<Integer>> actResultList = test018FourSum.fourSumExample(Arrays.copyOf(nums, nums.length), target);
        List<List<Integer>> actResultList01 = test018FourSum.fourSum(Arrays.copyOf(nums, nums.length), target);
        Assertions.assertEquals(expectedResults.size(), actResultList.size());
        Assertions.assertEquals(expectedResults.size(), actResultList01.size());
        actResultList.forEach(x -> x.sort(Integer::compareTo));
        actResultList01.forEach(x -> x.sort(Integer::compareTo));

        for (int i = 0; i < expectedResults.size(); i++) {
            Assertions.assertEquals(expectedResults.get(i).size(), actResultList.get(i).size());
            Assertions.assertEquals(expectedResults.get(i).size(), actResultList01.get(i).size());
        }

        for (int i = 0; i < expectedResults.size(); i++) {
            for (int j = 0; j < expectedResults.get(i).size(); j++) {
                Assertions.assertEquals(expectedResults.get(i).get(j), actResultList.get(i).get(j));
                Assertions.assertEquals(expectedResults.get(i).get(j), actResultList01.get(i).get(j));
            }
        }
    }


    public static Stream<Arguments> generateOriginRightCase() {
        return Stream.of(
                arguments(new int[]{-1, 0, 1, 2, -1, -4}, 0, List.of(Arrays.asList(-1, -1, 2), Arrays.asList(-1, 0, 1))),
                arguments(new int[]{-1, 0, 1, 2, -4}, 0, List.of(Arrays.asList(-1, 0, 1))),
                arguments(new int[]{0, 0, 0, 0, 0}, 0, List.of(Arrays.asList(0, 0, 0))),
                arguments(new int[]{0, 1, 1}, 0, List.of()),
                arguments(new int[]{0, 0, 0}, 0, List.of(Arrays.asList(0, 0, 0))),
                arguments(new int[]{3, 2, -5}, 0, List.of(Arrays.asList(3, 2, -5)))
        );
    }

}
