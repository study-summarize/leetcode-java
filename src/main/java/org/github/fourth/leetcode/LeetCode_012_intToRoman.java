package org.github.fourth.leetcode;

/**
 * @author jwang55
 */
public class LeetCode_012_intToRoman {


    public String intToRoman(int num) {
        // note: 因为map的key没有顺序，而我们又想让key从大到小排序，所以这里就拆分成俩个数组
        // 7种常规 + 6种特殊：从大到小
        int[] nums = new int[]{
                1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = new String[]{
                "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 13; i++) {
            while (num >= nums[i]) {
                num -= nums[i];
                sb.append(romans[i]);
            }
        }
        return sb.toString();
    }

}
