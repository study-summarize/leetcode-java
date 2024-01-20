package org.github.fourth.leetcode.lcr;

/**
 * 教练使用整数数组 actions 记录一系列核心肌群训练项目编号。为增强训练趣味性，需要将所有奇数编号训练项目调整至偶数编号训练项目之前。请将调整后的训练项目编号以 数组 形式返回。
 */
public class LCR_139_trainingPlan {
    /**
     * 时间复杂度：
     * 空间复杂度：
     */
    public int[] trainingPlan(int[] actions) {
        if (actions == null || actions.length == 0) {
            return null;
        }

        int evenPos = actions.length;
        for (int i = 0; i < evenPos; i++) {
            if (actions[i] % 2 == 0) {
                swap(actions, i, --evenPos);
            }
        }
        return actions;
    }

    private static void swap(int[] nums, int pos, int targetPos) {
        int temp = nums[pos];
        nums[pos] = nums[targetPos];
        nums[targetPos] = temp;
    }
}
