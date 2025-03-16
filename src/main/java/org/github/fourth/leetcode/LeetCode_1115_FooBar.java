package org.github.fourth.leetcode;

public class LeetCode_1115_FooBar {

    public static class FooBar {
        private int n;

        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {

                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {

                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
            }
        }
    }

    public static class PrintABC {

        // 共享变量，表示当前应该打印哪个字母
        private static int state = 0;

        // 共享对象，作为锁和通信的媒介
        private static final Object LOCK = new Object();

        public static void main(String[] args) {
            // 创建三个线程
            Thread threadA = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        // 循环100次
                        for (int i = 0; i < 100; i++) {
                            // 获取锁
                            synchronized (LOCK) {
                                // 判断是否轮到自己执行
                                while (state % 3 != 0) {
                                    LOCK.wait();
                                    // 不是则等待
                                }
                                // 打印字母
                                System.out.println("A");
                                // 修改状态
                                state++;
                                // 唤醒下一个线程
                                LOCK.notifyAll();
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

            Thread threadB = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        for (int i = 0; i < 100; i++) {
                            synchronized (LOCK) {
                                while (state % 3 != 1) {
                                    LOCK.wait();
                                }
                                System.out.println("B");
                                state++;
                                LOCK.notifyAll();
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

            Thread threadC = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        for (int i = 0; i < 100; i++) {
                            synchronized (LOCK) {
                                while (state % 3 != 2) {
                                    LOCK.wait();
                                }
                                System.out.println("C");
                                state++;
                                LOCK.notifyAll();
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

            // 启动三个线程
            threadA.start();
            threadB.start();
            threadC.start();
        }
    }
}
