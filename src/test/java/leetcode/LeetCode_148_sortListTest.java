package leetcode;

import org.github.fourth.leetcode.LeetCode_148_sortList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.github.fourth.struct.linkedlist.ListNode;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("XXXX")
class LeetCode_148_sortListTest {
    private final LeetCode_148_sortList sortList = new LeetCode_148_sortList();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(ListNode head, ListNode expectedResult) {
        ListNode actResult = sortList.sortList(head);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{1,8,6,2,5,4,8,3,7}, 49),
                arguments(new int[]{1,1}, 1)
        );
    }
}