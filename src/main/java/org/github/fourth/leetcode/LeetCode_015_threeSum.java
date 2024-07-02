package org.github.fourth.leetcode;

import org.github.fourth.Top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Origin:
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。
 * <br/>
 * Change:
 * 给定一个包含n个整数的数组（无重复元素）nums和一个目标值target，找出数组中和为目标值的三个数。可以假设每个输入只对应一种答案。
 */
@Top100
public class LeetCode_015_threeSum {

    /**
     * 消元：转换成俩数之和
     * 时间复杂度：O(nlogn) + nO(n) = O(n^2);
     * 空间复杂度：O（1）
     */
    public List<List<Integer>> threeSum01(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        // 返回值不是下标，这里其实可以无脑排序一下
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            // 前后数值相同时，后面的排序其实就是重复操作。这里可以想特殊案例：0,0,0,0
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    start++;
                    end--;
                    // 去除重复元素。这里也是可以想特殊案例：0,0,0,0,0,0
                    while (start > 1 && nums[start] == nums[start - 1] && start < nums.length - 1) {
                        start++;
                    }
                    while (end < nums.length - 1 && nums[end] == nums[end + 1] && end > 0) {
                        end--;
                    }
                } else if (sum > 0) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        return result;
    }

    /**
     * 模板代码
     * 时间复杂度：
     * 空间复杂度：
     */
    public List<List<Integer>> threeSumExample(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // 上一个元素已经将所有可能都遍历过了，因为要去重，所以这里直接跳过
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[start]);
                    list.add(nums[end]);
                    result.add(list);

                    start++;
                    end--;

                    // 去重：比如：-3,-1,0,0,1,2,3,3,3
                    // 去重现在nums[start]和原来nums[start]相等，因为后续如果还需要满足条件，结果集合的元素还是重复的
                    while (start < end && nums[start] == nums[start - 1]) {
                        start++;
                    }
                    // 去重现在nums[end]和原来nums[end]相等，因为后续如果还需要满足条件，结果集合的元素还是重复的
                    while (start < end && nums[end] == nums[end + 1]) {
                        end--;
                    }
                } else if (sum > 0) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        return result;
    }

    /**
     * 暴力解法：三层for循环
     * 时间复杂度：O(n^3)
     * 空间复杂度：O(1)
     */
    public int[] threeSumChange01(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int m = j + 1; m < nums.length; m++) {
                    if (nums[i] + nums[j] + nums[m] == target) {
                        return new int[]{nums[i], nums[j], nums[m]};
                    }
                }
            }
        }
        return null;
    }

    /**
     * 消元：转换成俩数之和
     * 时间复杂度：O(nlogn) + nO(n) = O(n^2)
     * 空间复杂度：O(1)
     */
    public int[] threeSumChange02(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        // note: 数组无序，且返回值跟下标无关时；基本上都是需要排序
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum == target) {
                    return new int[]{nums[i], nums[start], nums[end]};
                } else if (sum < target) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return null;
    }
}
