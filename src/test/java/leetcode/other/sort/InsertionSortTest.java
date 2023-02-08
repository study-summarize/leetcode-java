package leetcode.other.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author jwang55
 */
@DisplayName("插入排序测试")
public class InsertionSortTest {

    @Test
    public void test() {
        // arrange
        int[] nums = new int[]{4, 3, 5, 6, 2, 1, 10, 8, 7, 6, 6, 5};
        int[] target = new int[]{1, 2, 3, 4, 5, 5, 6, 6, 6, 7, 8, 10};
        // act
        new InsertionSort().sort(nums);
        // assert
        Assertions.assertArrayEquals(nums, target);
    }
}
