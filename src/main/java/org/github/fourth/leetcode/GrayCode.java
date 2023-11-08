package org.github.fourth.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jwang55
 */
public class GrayCode {

    public List<Integer> grayCode(int n) {
        // 解集
        List<Integer> result = new ArrayList<>();
        // 单一解
        StringBuffer sb = new StringBuffer();

        helper(result, sb, n, new int[]{0, 1});
        return result;
    }

    public void helper(List<Integer> result, StringBuffer sb, int n, int[] nums) {
        // 递归何时退出
        if (sb.length() == n) {
            // 转换成10进制
            int value = Integer.valueOf(sb.toString(), 2);
            result.add(value);
            return;
        }

        // 递归到下一层，如何取值？取0还是取1
        sb.append(nums[0]);
        helper(result, sb, n, new int[]{0, 1});
        // 回溯
        sb.deleteCharAt(sb.length() - 1);

        sb.append(nums[1]);
        helper(result, sb, n, new int[]{1, 0});
        sb.deleteCharAt(sb.length() - 1);
    }

}
