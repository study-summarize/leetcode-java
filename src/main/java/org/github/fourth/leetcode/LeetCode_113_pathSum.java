package org.github.fourth.leetcode;

import org.github.fourth.struct.bst.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * 叶子节点 是指没有子节点的节点。
 */
public class LeetCode_113_pathSum {
    /**
     * 时间复杂度：
     * 空间复杂度：
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return null;
        }
        // 解集
        List<List<Integer>> result = new ArrayList<>();
        // 单一解集
        List<Integer> list = new ArrayList<>();

        helper(result, list, root, targetSum);

        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> list, TreeNode root, int targetSum) {
        // 递归何时退出：叶子节点下方
        if (root == null) {
            return;
        }
        list.add(root.val);
        targetSum = targetSum - root.val;
        // 递归何时退出：叶子节点
        if (root.left == null && root.right == null) {
            // 单一解集何时加入解集：在叶子节点时，数字之和等于targetSum
            if (0 == targetSum) {
                result.add(list);
            }
            return;
        }

        if (root.left != null) {
            helper(result, list, root.left, targetSum);
            // 回溯
            list.remove(list.size() - 1);
        }

        if (root.right != null) {
            helper(result, list, root.right, targetSum);
            // 回溯
            list.remove(list.size() - 1);
        }
    }

}
