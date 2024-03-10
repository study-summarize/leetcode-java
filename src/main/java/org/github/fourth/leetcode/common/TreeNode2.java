package org.github.fourth.leetcode.common;


import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreeNode2 {
    public int val;
    public List<TreeNode2> children;

    public TreeNode2() {
    }

    public TreeNode2(Integer val) {
        this.val = val;
        this.children = new ArrayList<>();
    }

    public TreeNode2(int val, List<TreeNode2> children) {
        this.val = val;
        this.children = children;
    }

    public static TreeNode2 buildNTree(Map<Integer, List<Integer>> initMap, Integer root) {
        if (MapUtils.isEmpty(initMap) || root == null) {
            return null;
        }
        Map<Integer, TreeNode2> map = new HashMap<>();

        TreeNode2 result = new TreeNode2(root);
        map.put(result.val, result);

        for (Map.Entry<Integer, List<Integer>> entry : initMap.entrySet()) {
            TreeNode2 keyNode = map.getOrDefault(entry.getKey(), new TreeNode2(entry.getKey()));
            map.put(keyNode.val, keyNode);
            for (Integer node : entry.getValue()) {
                TreeNode2 childNode = map.getOrDefault(node, new TreeNode2(node));
                keyNode.children.add(childNode);
                map.put(childNode.val, childNode);
            }
        }
        return result;
    }

    public static TreeNode2 build2Tree(List<Integer> list) {
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        Map<Integer, TreeNode2> map = new HashMap<>();
        return TreeNode2.build2Tree(list, 0, list.size(), map);
    }

    private static TreeNode2 build2Tree(List<Integer> list, int i, int n, Map<Integer, TreeNode2> map) {
        if (i >= n || list.get(i) == null) {
            return null;
        }
        TreeNode2 root = map.getOrDefault(list.get(i), new TreeNode2(list.get(i)));

        TreeNode2 left = build2Tree(list, 2 * i + 1, n, map);
        if (left != null) {
            root.children.add(left);
        }
        TreeNode2 right = build2Tree(list, 2 * i + 2, n, map);
        if (right != null) {
            root.children.add(right);
        }
        return root;
    }


}
