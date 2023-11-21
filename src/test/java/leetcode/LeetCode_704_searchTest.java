package leetcode;

import org.github.fourth.leetcode.LeetCode_704_search;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("二分查找")
public class LeetCode_704_searchTest {

    private final LeetCode_704_search leetCode704Search = new LeetCode_704_search();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(int[] nums, int target, int expectedResult) {
        int actResult = this.leetCode704Search.search(Arrays.copyOf(nums, nums.length), target);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{-1, 0, 3, 5, 9, 12}, 9, 4),
                arguments(new int[]{-1, 0, 3, 5, 9, 12}, 2, -1)
        );
    }

}
