package org.github.fourth.leetcode;


import org.github.fourth.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * 叶子节点 是指没有子节点的节点。
 */
public class LeetCode_113_pathSum {
    /**
     * 回溯法
     * 时间复杂度：
     * 空间复杂度：
     */
    public List<List<Integer>> pathSum01(TreeNode root, int targetSum) {
        // 解集
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        // 单一解集
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        // 递归遍历解空间树
        helper(result, list, root, targetSum - root.val);
        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> list, TreeNode root, int targetSum) {
        // 1. 递归什么时候结束？root节点为叶子节点时
        // 2. 单一解集什么时候加入解集？ root节点为叶子节点，且targetSum为0
        if (root.left == null && root.right == null) {
            if (targetSum == 0) {
                result.add(new ArrayList<>(list));
            }
            return;
        }

        // 3. 分情况拆解 解空间树
        if (root.left != null) {
            // 3.1 扩展单一解集
            list.add(root.left.val);
            // 3.2 递归解空间树
            helper(result, list, root.left, targetSum - root.left.val);
            // 3.3 回溯
            list.remove(list.size() - 1);
        }
        if (root.right != null) {
            list.add(root.right.val);
            helper(result, list, root.right, targetSum - root.right.val);
            list.remove(list.size() - 1);
        }
    }

    /**
     * 回溯法
     * 时间复杂度：
     * 空间复杂度：
     */
    public List<List<Integer>> pathSumExample(TreeNode root, int targetSum) {
        if (root == null) {
            return new ArrayList<>();
        }
        // 解集
        List<List<Integer>> result = new ArrayList<>();
        // 单一解集
        List<Integer> list = new ArrayList<>();

        helperExample(result, list, root, targetSum);

        return result;
    }

    private void helperExample(List<List<Integer>> result, List<Integer> list, TreeNode root, int targetSum) {
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
                result.add(new ArrayList<>(list));
            }
            return;
        }

        if (root.left != null) {
            helperExample(result, list, root.left, targetSum);
            // 回溯
            list.remove(list.size() - 1);
        }

        if (root.right != null) {
            helperExample(result, list, root.right, targetSum);
            // 回溯
            list.remove(list.size() - 1);
        }
    }

}
