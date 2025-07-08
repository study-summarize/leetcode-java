package org.github.fourth;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 有3个线程，线程名分别为A、B、C。 A线程随机生成一个 0 - 100 之间的整数，
 * 仅生成一次，例如20。 线程名B、C进行猜数，并通知线程A，
 * 线程A会根据猜测的结果来通知B、C线程是猜大了、猜小了、还是猜正确了。
 * 猜数的线程B、C依据线程A给的提示继续猜数，
 * 如此循环。猜中以后，由A线程输出猜中的线程，并且三个线程都中止运行。
 * 请注意：
 * 1. 线程B和C需要等线程A生成猜数结果后，才开始参数
 * 2. 线程B和C任意哪个线程都可以先猜数，但两个线程需要轮流猜数
 */
@SuppressFBWarnings({"DMI_RANDOM_USED_ONLY_ONCE", "NN_NAKED_NOTIFY"})
public class Demo {

    private static String threadName = null;

    private static Object lock = new Object();
    private static AtomicBoolean guess = new AtomicBoolean(false);


    private static AtomicBoolean aEnd = new AtomicBoolean(false);
    private static AtomicBoolean bEnd = new AtomicBoolean(false);
    private static AtomicBoolean cEnd = new AtomicBoolean(false);


    private static AtomicInteger number = new AtomicInteger(-100);

    private static AtomicInteger answer = new AtomicInteger(-1);


    private static Semaphore semaphore = new Semaphore(1);

    public static void main(String[] args) throws InterruptedException {
        Thread a = new Thread(() -> {
            // 先生成随机数
            int count = new Random().nextInt(0, 100);
            System.out.println(String.format("确定值： %d", count));
            number.set(count);
            guess.set(false);
            synchronized (lock) {
                lock.notifyAll();
            }

            while (!aEnd.get()) {
                if (guess.get()) {
                    synchronized (lock) {
                        // 判断给的值
                        if (answer.get() == number.get()) {
                            System.out.printf("%s is right: %d%n", threadName, number.get());
                            aEnd.set(true);
                            bEnd.set(true);
                            cEnd.set(true);
                            lock.notifyAll();
                        }
                        guess.set(false);
                    }

                }
            }
            System.out.println("A stop");
        });
        //
        Thread b = new Thread(() -> {

            while (!bEnd.get()) {
                if (bEnd.get()) {
                    break;
                }
                synchronized (lock) {
                    // 什么情况下，b不可以猜
                    while (guess.get() || !giveAnswer(number) || "C".equals(threadName)) {
                        try {
                            if (bEnd.get()) {
                                break;
                            }
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    if (bEnd.get()) {
                        break;
                    }
                    // b init
                    if (!giveAnswer(answer)) {
                        answer.set(new Random().nextInt(0, 100));
                    }


                    if (!guess.get() && giveAnswer(number) && semaphore.tryAcquire()) {
                        try {
                            if (answer.get() > number.get()) {
                                answer.set(new Random().nextInt(0, answer.get()));
                            } else {
                                answer.set(new Random().nextInt(answer.get(), 100));
                            }
                            System.out.println(String.format("%s guess %d", "B", answer.get()));
                            guess.set(true);
                            threadName = "C";
                        } finally {
                            semaphore.release();
                        }
                    }
                    lock.notifyAll();
                }
            }
            System.out.println("B stop");

        });
        // C
        Thread c = new Thread(() -> {
            while (!cEnd.get()) {
                synchronized (lock) {
                    while (guess.get() || !giveAnswer(number) || "B".equals(threadName)) {
                        try {
                            if (cEnd.get()) {
                                break;
                            }
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    if (cEnd.get()) {
                        break;
                    }
                    if (!giveAnswer(answer)) {
                        answer.set(new Random().nextInt(0, 100));
                    }
                    if (!guess.get() && giveAnswer(number) && semaphore.tryAcquire()) {
                        try {
                            if (answer.get() > number.get()) {
                                answer.set(new Random().nextInt(0, answer.get()));
                            } else {
                                answer.set(new Random().nextInt(answer.get(), 100));
                            }
                            System.out.println(String.format("%s guess %d", "C", answer.get()));
                            guess.set(true);
                            threadName = "B";
                        } finally {
                            semaphore.release();
                        }
                    }
                    lock.notifyAll();
                }
            }
            System.out.println("C stop");
        });


        a.start();
        b.start();
        c.start();
    }


    public static boolean giveAnswer(AtomicInteger bAnswer) {
        return bAnswer.get() >= 0
                && bAnswer.get() <= 100;
    }
}
