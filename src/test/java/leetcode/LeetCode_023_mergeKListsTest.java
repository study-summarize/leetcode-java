package leetcode;

import org.github.fourth.leetcode.LeetCode_023_mergeKLists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.github.fourth.struct.linkedlist.ListNode;

import java.util.stream.Stream;

@DisplayName("合并 K 个升序链表测试")
class LeetCode_023_mergeKListsTest {

    private final LeetCode_023_mergeKLists mergeKLists = new LeetCode_023_mergeKLists();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(ListNode[] lists, ListNode expectedResult) {

        ListNode actResult = mergeKLists.mergeKLists(lists);
        // todo: 如何比较两个链表是否相等？
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
        );
    }

}