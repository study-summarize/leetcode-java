package org.github.fourth.leetcode;

import java.util.Arrays;

/**
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 * 返回这三个数的和。
 * 假定每组输入只存在恰好一个解。
 */
public class LeetCode_016_threeSumClosest {

    /**
     * 思路：
     * 这里其实就相当于全部计算一遍，找出最合适的解。
     * 优化点：
     * 1、可以参考15去除重复计算
     */
    public int threeSumClosest01(int[] nums, int target) {
        int result = Integer.MAX_VALUE;
        if (nums == null || nums.length < 3) {
            return -1;
        }

        Arrays.sort(nums);

        int currentAbs = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int startIndex = i + 1;
            int endIndex = nums.length - 1;
            while (startIndex < endIndex) {
                int currentSum = nums[i] + nums[startIndex] + nums[endIndex];
                if (currentAbs > Math.abs(currentSum - target)) {
                    currentAbs = Math.abs(currentSum - target);
                    result = currentSum;
                }

                if (currentSum - target > 0) {
                    endIndex--;
                }
                else if (currentSum - target < 0) {
                    startIndex++;
                }
                else {
                    return result;
                }
            }
        }
        return result;
    }

    /**
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(1)
     * note: 去重属于优化，写不出来可以不写
     */
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return -1;
        }

        // 先排序
        Arrays.sort(nums);

        int abs = Integer.MAX_VALUE;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            // 去重1：这里为啥不能while。1,1,1,1 => 0
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }


            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum == target) {
                    return sum;
                } else if (sum > target) {
                    if (Math.abs(sum - target) < abs) {
                        abs = Math.abs(sum - target);
                        result = sum;
                    }
                    end--;
                    // 去重2：
                    while (start < end && nums[end] == nums[end + 1]) {
                        end--;
                    }
                } else {
                    if (Math.abs(sum - target) < abs) {
                        abs = Math.abs(sum - target);
                        result = sum;
                    }
                    start++;
                    // 去重3：
                    while (start < end && nums[start] == nums[start - 1]) {
                        start++;
                    }
                }
            }
        }
        return result;
    }

    /**
     * 时间复杂度：
     * 空间复杂度：
     */
    public int threeSumClosestExample(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        Arrays.sort(nums);

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            // 去重1
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum == target) {
                    return target;
                }

                result = Math.abs(sum - target) > Math.abs(result - target) ? result : sum;

                if (sum > target) {
                    end--;
                    // 去重2：
                    while (start < end && nums[end] == nums[end + 1]) {
                        end--;
                    }
                } else {
                    start++;
                    // 去重2：
                    while (start < end && nums[start] == nums[start - 1]) {
                        start++;
                    }
                }
            }
        }
        return result;
    }
}
