package org.github.fourth.leetcode;

import org.github.fourth.struct.bst.TreeNode;

import java.util.*;

/**
 * @author jwang55
 */
public class LeetCode_103_zigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        // 1、构建队列
        Queue<TreeNode> queue = new LinkedList<>();

        // 2、根节点进入队列
        queue.offer(root);

        // 3、层序遍历
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                levelList.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(levelList);
        }

        for (int i = 0; i < result.size(); i++) {
            if (i % 2 != 0) {
                List<Integer> list = result.get(i);
                Collections.reverse(list);
            }
        }
        return result;
    }

}
