package org.github.fourth.leetcode;

import org.github.fourth.struct.bst.TreeNode;

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
     * 时间复杂度：
     * 空间复杂度：
     */
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 解集
        List<String> result = new ArrayList<>();
        // 单一解集
        StringBuffer sb = new StringBuffer();

        helper(result, sb, root);

        // 计算结果
        return result.stream().map(Integer::valueOf).reduce(0, Integer::sum);
    }

    private void helper(List<String> result, StringBuffer sb, TreeNode root) {
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
            helper(result, sb, root.left);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (root.right != null) {
            helper(result, sb, root.right);
            // 回溯
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
