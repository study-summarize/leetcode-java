package org.github.fourth;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

import java.util.HashMap;
import java.util.Map;

/**
 * 滑动窗口模板
 *
 * @author jwang55
 */
public class SlidingWindowDemo {

    @SuppressFBWarnings({"DLS_DEAD_LOCAL_STORE", "UC_USELESS_VOID_METHOD"})
    public void slidingWindow(int[] nums) {
        // 可能需要map记录窗口内元素
        Map<Integer, Integer> map = new HashMap<>();

        // 同向型双指针
        int i = 0;
        int j = 0;

        // 外层for循环，内层while循环为主体
        for (i = 0; i < nums.length; i++) {
            while (j < nums.length) {
                // 搞清窗口扩展条件
                if (CONDITION) {
                    // 更新j状态，窗口内数据更新
                    j++;
                } else {
                    break;
                }
            }
            // 窗口收缩条件
            // 更新i的状态，窗口内数据更新
        }
    }

    // 题目条件的扩展条件
    private static final boolean CONDITION = true;
}
