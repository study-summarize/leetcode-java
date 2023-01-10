package struct.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author jwang55
 */
@DisplayName("单链表测试")
public class MyLinkedListTest {

    @DisplayName("测试大部分功能")
    @Test
    public void test() {
        MyLinkedList list = new MyLinkedList();
        list.add(0, 2);
        list.add(1, 3);
        list.add(2, 1);
        list.add(3, 6);
        list.add(4, 5);

        // 测试添加功能
        Assertions.assertEquals(6, list.get(3));
        Assertions.assertEquals(1, list.get(2));

        // 测试长度：5
        Assertions.assertEquals(5, list.length);
        Assertions.assertEquals(5, list.getLengthByTraverse());

        // 测试添加
        // index = 3, value 7; index = 4, value = 6
        list.add(3, 7);
        Assertions.assertEquals(7, list.get(3));
        Assertions.assertEquals(6, list.get(4));

        // 测试在最后添加
        // index = 6, value = 100
        list.append(100);
        Assertions.assertEquals(100, list.get(6));

        // 测试修改
        // index = 5, value = 1000
        list.set(5, 1000);
        Assertions.assertEquals(1000, list.get(5));

        // 测试长度
        Assertions.assertEquals(7, list.length);

        // 测试删除
        // 2 3 1 6 1000 100 null
        list.removeByIndex(3);
        Assertions.assertEquals(6, list.get(3));
        Assertions.assertEquals(1000, list.get(4));
        Assertions.assertEquals(100, list.get(5));

        // 测试删除
        // 3 1 6 1000 100 null
        list.removeByIndex(0);
        Assertions.assertEquals(1000, list.get(3));
        Assertions.assertEquals(100, list.get(4));

        // 测试长度
        Assertions.assertEquals(5, list.length);
        Assertions.assertEquals(5, list.getLengthByTraverse());

        // 测试使用dummyNode添加
        // 99 3 1 6 1000 100 null
        list.addWithDummyNode(0, 99);
        Assertions.assertEquals(99, list.get(0));

        // 测试使用dummyNode删除
        // 99 1 6 1000 100 null
        list.removeByIndexWithDummyNode(1);
        Assertions.assertEquals(1, list.get(1));
    }

}
