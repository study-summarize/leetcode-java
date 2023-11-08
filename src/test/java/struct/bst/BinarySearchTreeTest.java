package struct.bst;

import org.github.fourth.struct.bst.BinarySearchTree;
import org.github.fourth.struct.bst.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author jwang55
 */
@DisplayName("二分查找树测试")
public class BinarySearchTreeTest {

    @DisplayName("测试大部分功能")
    @Test
    public void test() {
        TreeNode root = new TreeNode(30);
        TreeNode node1 = new TreeNode(19);
        TreeNode node2 = new TreeNode(34);
        root.setLeft(node1);
        root.setRight(node2);

        TreeNode node3 = new TreeNode(12);
        TreeNode node4 = new TreeNode(22);
        TreeNode node5 = new TreeNode(31);
        TreeNode node6 = new TreeNode(42);
        node1.setLeft(node3);
        node1.setRight(node4);
        node2.setLeft(node5);
        node2.setRight(node6);

        TreeNode node7 = new TreeNode(20);
        TreeNode node8 = new TreeNode(28);
        TreeNode node9 = new TreeNode(36);
        TreeNode node10 = new TreeNode(47);
        node4.setLeft(node7);
        node4.setRight(node8);
        node6.setLeft(node9);
        node6.setRight(node10);

        BinarySearchTree bst = new BinarySearchTree(root);

        // find
        Assertions.assertTrue(bst.find(22));
        Assertions.assertFalse(bst.find(45));

        // add 45
        bst.add(45);
        Assertions.assertTrue(bst.find(22));
        Assertions.assertTrue(bst.find(45));

    }

}
