package org.github.fourth.leetcode;

public class LeetCode_014_longestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }

        String result = strs[0];
        for (int i = 1; i < strs.length; i++) {
            result = longestCommonPrefix(result, strs[i]);
            if (result == null || result.length() == 0) {
                return result;
            }
        }
        return result;
    }

    public String longestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }
}


class Test {

    private static Object lock = new Object();
    private static int number = 0;

    public static void main(String[] args) {
        Thread a = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    while (number % 2 != 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println("偶数线程：" + number);
                    ++number;
                    lock.notifyAll();
                }
            }
        });
        Thread b = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    while (number % 2 == 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println("奇数线程：" + number);
                    ++number;
                    lock.notifyAll();
                }
            }
        });


        a.start();
        b.start();
    }
}
