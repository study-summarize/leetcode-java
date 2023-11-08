package leetcode;

import org.github.fourth.leetcode.LeetCode_147_insertionSortList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.github.fourth.struct.linkedlist.ListNode;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("对链表进行插入排序 测试")
class Test_147_insertionSortListTest {
    private final LeetCode_147_insertionSortList insertionSortList = new LeetCode_147_insertionSortList();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(ListNode head, ListNode expectedResult) {
        ListNode actResult = insertionSortList.insertionSortList(head);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}, 49),
                arguments(new int[]{1, 1}, 1)
        );
    }
}