package leetcode.other.sort;

/**
 * 插入排序
 *
 * @author jwang55
 */
public class InsertionSort {

    public void sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        // note: 为什么从1开始？因为第一个元素不需要进行排序
        for (int j = 1; j < nums.length; j++) {
            // 已经排好序的最右边元素
            int i = j - 1;

            int key = nums[j];
            // 从右往左比较:从排好序的最左边开始比较，直至找到第一个比他小的元素，把元素放在这个位置的后边
            while (i >= 0 && nums[i] > key) {
                nums[i + 1] = nums[i];
                i--;
            }
            nums[i + 1] = key;
        }
    }
}
