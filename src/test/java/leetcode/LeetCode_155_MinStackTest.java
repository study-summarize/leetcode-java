package leetcode;

import org.github.fourth.leetcode.LeetCode_155_MinStack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("最小栈")
public class LeetCode_155_MinStackTest {

    @Test
    public void test() {
        LeetCode_155_MinStack minStack = new LeetCode_155_MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        Assertions.assertEquals(-3, minStack.getMin());
        minStack.pop();
        Assertions.assertEquals(0, minStack.top());
        Assertions.assertEquals(-2, minStack.getMin());
    }
}
