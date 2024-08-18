package org.github.fourth.scene;

public class Print123 {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();
    private static final Object lock3 = new Object();

    public static void main(String[] args) throws InterruptedException {


        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        synchronized (lock3) {
                            // 只有获取lock1才输出
                            synchronized (lock1) {
                                System.out.print("1");
                                lock1.notifyAll();
                            }
                            // 禁止第二个打印
                            lock3.wait();
                        }
                    } catch (Exception ignore) {

                    }
                }

            }
        }).start();
        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    synchronized (lock1) {
                        synchronized (lock2) {
                            // 只有获取lock2才输出
                            System.out.print("2");
                            lock2.notifyAll();
                        }

                        try {
                            lock1.wait();
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
                        synchronized (lock2) {
                            // 只有获取lock3才输出
                            synchronized (lock3) {
                                System.out.println("3");
                                lock3.notifyAll();
                            }
                            lock2.wait();
                        }
                    } catch (Exception ignore) {

                    }
                }
            }
        }).start();

        Thread.sleep(10 * 000);
    }

}
