package org.github.fourth.leetcode;

/**
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <br/>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给你一个整数，将其转为罗马数字。
 */
public class LeetCode_012_intToRoman {

    /**
     * 思路：暴力方法
     * 从千位数依次向下解决，遇见4、9就特殊处理
     */
    public String intToRoman01(int num) {
        StringBuilder result = new StringBuilder();
        if (num <= 0) {
            return result.toString();
        }

        // 先从最高位开始
        int mCount = num / 1000;
        for (int i = 0; i < mCount; i++) {
            result.append("M");
        }
        num = num % 1000;

        // D
        int dCount = num / 100;
        if (dCount > 0 && dCount < 4) {
            for (int i = 0; i < dCount; i++) {
                result.append("C");
            }
        } else if (dCount == 4) {
            result.append("CD");
        } else if (dCount > 4 && dCount < 9) {
            result.append("D");
            for (int i = 0; i < dCount - 5; i++) {
                result.append("C");
            }
        }
        if (dCount == 9) {
            result.append("CM");
        }
        num = num % 100;

        // L
        int lCount = num / 10;
        if (lCount > 0 && lCount < 4) {
            for (int i = 0; i < lCount; i++) {
                result.append("X");
            }
        } else if (lCount == 4) {
            result.append("XL");
        } else if (lCount > 4 && lCount < 9) {
            result.append("L");
            for (int i = 0; i < lCount - 5; i++) {
                result.append("X");
            }
        }
        if (lCount == 9) {
            result.append("XC");
        }
        num = num % 10;

        // I
        int iCount = num;
        if (iCount > 0 && iCount < 4) {
            for (int i = 0; i < iCount; i++) {
                result.append("I");
            }
        } else if (iCount == 4) {
            result.append("IV");
        } else if (iCount > 4 && iCount < 9) {
            result.append("V");
            for (int i = 0; i < iCount - 5; i++) {
                result.append("I");
            }
        }
        if (iCount == 9) {
            result.append("IX");
        }
        return result.toString();
    }

    /**
     * 思路：
     * 其实上次的计算就是从最大的数向最小的数，不断相减来满足。我们可以把所有罗马数据都整合到一个Map，然后按照阿拉伯数据从大到小依次相减
     * <br/>
     * 时间复杂度：
     * 空间复杂度：
     */
    public String intToRoman(int num) {
        // note: 因为map的key没有顺序，而我们又想让key从大到小排序，所以这里就拆分成俩个数组
        // 7种常规 + 6种特殊：从大到小
        int[] nums = new int[]{
                1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = new String[]{
                "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        // 从大到小来计算
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
