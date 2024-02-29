package org.github.fourth.leetcode;


import org.github.fourth.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
/**
 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 * 叶节点 是指没有子节点的节点。
 */
public class LeetCode_129_sumNumbers {
    /**
     * 回溯法：
     * 时间复杂度：
     * 空间复杂度：
     */
    public int sumNumbers01(TreeNode root) {
        // 解集
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return 0;
        }
        // 单一解集
        StringBuffer sb = new StringBuffer();
        sb.append(root.val);
        // 递归遍历解空间树
        helper(result, sb, root);
        // 计算出结果
        return result.stream().reduce(Integer::sum).orElse(0);
    }

    private void helper(List<Integer> result, StringBuffer sb, TreeNode root) {
        // 1. 递归什么时候结束？
        // 2. 单一解集什么时候加入解集？root为叶子节点时
        if (root.left == null && root.right == null) {
            result.add(Integer.valueOf(sb.toString()));
            return;
        }

        // 3. 递归解空间树
        if (root.left != null) {
            // 扩展当前解集
            sb.append(root.left.val);
            // 递归找解空间树
            helper(result, sb, root.left);
            // 回溯
            sb.deleteCharAt(sb.length() - 1);
        }
        if (root.right != null) {
            // 扩展当前解集
            sb.append(root.right.val);
            // 递归找解空间树
            helper(result, sb, root.right);
            // 回溯
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    /**
     * 时间复杂度：
     * 空间复杂度：
     */
    public int sumNumbersExample(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 解集
        List<String> result = new ArrayList<>();
        // 单一解集
        StringBuffer sb = new StringBuffer();

        helperExample(result, sb, root);

        // 计算结果
        return result.stream().map(Integer::valueOf).reduce(0, Integer::sum);
    }

    private void helperExample(List<String> result, StringBuffer sb, TreeNode root) {
        if (root == null) {
            return;
        }
        sb.append(root.val);
        // 递归什么时候结束：到达叶子节点
        if (root.left == null && root.right == null) {
            result.add(sb.toString());
            return;
        }

        if (root.left != null) {
            helperExample(result, sb, root.left);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (root.right != null) {
            helperExample(result, sb, root.right);
            // 回溯
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
