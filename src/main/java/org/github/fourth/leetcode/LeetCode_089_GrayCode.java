package org.github.fourth.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * n 位格雷码序列 是一个由 2n 个整数组成的序列，其中：
 * - 每个整数都在范围 [0, 2n - 1] 内（含 0 和 2n - 1）
 * - 第一个整数是 0
 * - 一个整数在序列中出现 不超过一次
 * - 每对 相邻 整数的二进制表示 恰好一位不同 ，且
 * - 第一个 和 最后一个 整数的二进制表示 恰好一位不同
 * 给你一个整数 n ，返回任一有效的 n 位格雷码序列 。
 */
public class LeetCode_089_GrayCode {
    /**
     * 时间复杂度：
     * 空间复杂度：
     */
    public List<Integer> grayCode(int n) {
        // 解集
        List<Integer> result = new ArrayList<>();
        // 单一解
        StringBuffer sb = new StringBuffer();

        helper(result, sb, n, new int[]{0, 1});
        return result;
    }

    public void helper(List<Integer> result, StringBuffer sb, int n, int[] nums) {
        // 递归何时退出
        if (sb.length() == n) {
            // 转换成10进制
            int value = Integer.valueOf(sb.toString(), 2);
            result.add(value);
            return;
        }

        // 递归到下一层，如何取值？取0还是取1
        sb.append(nums[0]);
        helper(result, sb, n, new int[]{0, 1});
        // 回溯
        sb.deleteCharAt(sb.length() - 1);

        sb.append(nums[1]);
        helper(result, sb, n, new int[]{1, 0});
        sb.deleteCharAt(sb.length() - 1);
    }

}
