package leetcode;

import org.github.fourth.leetcode.LeetCode_147_insertionSortList;
import org.github.fourth.leetcode.common.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("对链表进行插入排序")
class LeetCode_147_insertionSortListTest {
    private final LeetCode_147_insertionSortList insertionSortList = new LeetCode_147_insertionSortList();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(ListNode head, ListNode expectedResult) {
        ListNode actResult = insertionSortList.insertionSortList(head);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(ListNode.build(4, 2, 1, 3), ListNode.build(1, 2, 3, 4)),
                arguments(ListNode.build(-1, 5, 3, 4, 0), ListNode.build(-1, 0, 3, 4, 5))
        );
    }
}