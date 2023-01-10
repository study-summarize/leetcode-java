package struct;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import struct.array.MyArrayList;

/**
 * @author jwang55
 */
@DisplayName("数组列表测试")
public class MyArrayListTest {

    @DisplayName("测试添加")
    @Test
    public void testAdd() {
        MyArrayList<Integer> list1 = new MyArrayList<>();

        list1.add(1);
        list1.add(2);
        list1.add(3);
        int len = list1.length();
        Assertions.assertEquals(3, len);
        Assertions.assertFalse(list1.isEmpty());
        for (int i = 0; i < len; i++) {
            Assertions.assertEquals(i + 1, list1.get(i));
        }
    }
}
