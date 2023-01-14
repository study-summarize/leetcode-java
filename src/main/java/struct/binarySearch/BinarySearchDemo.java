package struct.binarySearch;

/**
 *
 *
 * 1、相关题目
 * - 704-二分查找：https://leetcode.cn/problems/binary-search/
 * - 278-第一个错误的版本：https://leetcode.cn/problems/first-bad-version/
 * - 034-在排序数组中查找元素的第一个和最后一个位置：https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/
 * - 035-搜索插入位置：https://leetcode.cn/problems/search-insert-position/
 * - 074-搜索二维矩阵：https://leetcode.cn/problems/search-a-2d-matrix/
 * - 240-搜索二维矩阵II：https://leetcode.cn/problems/search-a-2d-matrix-ii/
 * - 069-x的平方根：https://leetcode.cn/problems/sqrtx/
 * （2）数组区间的二分有序问题
 * - 153-寻找旋转排序数组中的最小值：https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/
 * - 154-寻找旋转排序数组中的最小值II：https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array-ii/
 * - 852-山脉数组的峰顶索引：https://leetcode.cn/problems/peak-index-in-a-mountain-array/
 * - 033-搜索旋转排序数组：https://leetcode.cn/problems/search-in-rotated-sorted-array/
 *
 */
public class BinarySearchDemo {

    public int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (target < nums[mid]) {
                end = mid;
            }
            else if (target > nums[mid]) {
                start = mid;
            }
            else {
                end = mid;
            }
        }

        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        return -1;
    }
}
