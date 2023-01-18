package leetcode;

import struct.bst.TreeNode;

import java.util.ArrayList;
import java.util.List;
/**
 * @author jwang55
 */
public class Test_129_sumNumbers {

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
