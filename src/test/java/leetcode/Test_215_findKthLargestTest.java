package leetcode;

import org.github.fourth.leetcode.LeetCode_215_findKthLargest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("数组中的第K大元素 测试")
class Test_215_findKthLargestTest {
    private final LeetCode_215_findKthLargest findKthLargest = new LeetCode_215_findKthLargest();


    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(int[] nums, int k,int expectedResult) {

        int actResult1 = findKthLargest.findKthLargest(nums, k);
        Assertions.assertEquals(expectedResult, actResult1);

        int actResult2 = findKthLargest.findKthLargest2(nums, k);
        Assertions.assertEquals(expectedResult, actResult2);

        int actResult3 = findKthLargest.findKthLargest3(nums, k);
        Assertions.assertEquals(expectedResult, actResult3);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{1,8,6,2,5,4,8,3,7}, 49),
                arguments(new int[]{1,1}, 1)
        );
    }
}