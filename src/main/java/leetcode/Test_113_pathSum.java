package leetcode;

import struct.bst.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jwang55
 */
public class Test_113_pathSum {

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
