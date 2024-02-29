package org.github.fourth.leetcode.lcr;

/**
 * 教练使用整数数组 actions 记录一系列核心肌群训练项目编号。为增强训练趣味性，需要将所有奇数编号训练项目调整至偶数编号训练项目之前。请将调整后的训练项目编号以 数组 形式返回。
 */
public class LCR_139_trainingPlan {

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public int[] trainingPlanExample(int[] actions) {
        int i = 0, j = actions.length - 1, tmp;
        while (i < j) {
            while (i < j && (actions[i] & 1) == 1) i++;
            while (i < j && (actions[j] & 1) == 0) j--;
            tmp = actions[i];
            actions[i] = actions[j];
            actions[j] = tmp;
        }
        return actions;
    }

    private static void swap(int[] nums, int pos, int targetPos) {
        int temp = nums[pos];
        nums[pos] = nums[targetPos];
        nums[targetPos] = temp;
    }
}
