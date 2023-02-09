package leetcode.other.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author jwang55
 */
@DisplayName("排序测试")
public class SortTest {

    private static final int[] target = new int[]{1, 2, 3, 4, 5, 5, 6, 6, 6, 7, 8, 10};

    @Test
    @DisplayName("插入排序测试")
    public void insertionSortTest() {
        // arrange
        int[] nums = new int[]{4, 3, 5, 6, 2, 1, 10, 8, 7, 6, 6, 5};
        // act
        new InsertionSort().sort(nums);
        // assert
        Assertions.assertArrayEquals(nums, target);
    }

    @Test
    @DisplayName("冒泡排序测试")
    public void bubbleSortTest() {
        // arrange
        int[] nums = new int[]{4, 3, 5, 6, 2, 1, 10, 8, 7, 6, 6, 5};
        // act
        new BubbleSort().sort(nums);
        // assert
        Assertions.assertArrayEquals(nums, target);
    }

    @Test
    @DisplayName("优化版冒泡排序测试")
    public void bubbleSort2Test() {
        // arrange
        int[] nums = new int[]{4, 3, 5, 6, 2, 1, 10, 8, 7, 6, 6, 5};
        // act
        new BubbleSort().betterSort(nums);
        // assert
        Assertions.assertArrayEquals(nums, target);
    }

    @Test
    @DisplayName("归并排序1测试")
    public void mergeSort1Test() {
        // arrange
        int[] nums = new int[]{4, 3, 5, 6, 2, 1, 10, 8, 7, 6, 6, 5};
        // act
        new MergeSort().sort(nums);
        // assert
        Assertions.assertArrayEquals(nums, target);
    }

    @Test
    @DisplayName("归并排序2测试")
    public void mergeSort2Test() {
        // arrange
        int[] nums = new int[]{4, 3, 5, 6, 2, 1, 10, 8, 7, 6, 6, 5};
        // act
        new MergeSort().sort2(nums);
        // assert
        Assertions.assertArrayEquals(nums, target);
    }
}
