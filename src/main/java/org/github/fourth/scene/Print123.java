package org.github.fourth.scene;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

@SuppressFBWarnings("REC_CATCH_EXCEPTION")
public class Print123 {
    private static final Object LOCK_1 = new Object();
    private static final Object LOCK_2 = new Object();
    private static final Object LOCK_3 = new Object();

    public static void main(String[] args) throws InterruptedException {


        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        synchronized (LOCK_3) {
                            // 只有获取lock1才输出
                            synchronized (LOCK_1) {
                                System.out.print("1");
                                LOCK_1.notifyAll();
                            }
                            // 禁止第二个打印
                            LOCK_3.wait();
                        }
                    } catch (Exception ignore) {

                    }
                }

            }
        }).start();
        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    synchronized (LOCK_1) {
                        synchronized (LOCK_2) {
                            // 只有获取lock2才输出
                            System.out.print("2");
                            LOCK_2.notifyAll();
                        }

                        try {
                            LOCK_1.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                }
            }
        }).start();
        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        synchronized (LOCK_2) {
                            // 只有获取lock3才输出
                            synchronized (LOCK_3) {
                                System.out.println("3");
                                LOCK_3.notifyAll();
                            }
                            LOCK_2.wait();
                        }
                    } catch (Exception ignore) {

                    }
                }
            }
        }).start();

        Thread.sleep(10 * 000);
    }

}
