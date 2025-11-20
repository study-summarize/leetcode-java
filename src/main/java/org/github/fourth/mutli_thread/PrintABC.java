package org.github.fourth.mutli_thread;

import java.util.concurrent.Semaphore;

public class PrintABC {

    private static final Semaphore semaphoreA = new Semaphore(1);
    private static final Semaphore semaphoreB = new Semaphore(0);
    private static final Semaphore semaphoreC = new Semaphore(0);
    private static final int count = 0;

    public void printA() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            semaphoreA.acquire();
            System.out.println("A");
            semaphoreB.release();
        }
    }
    public void printB() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            semaphoreB.acquire();
            System.out.println("B");
            semaphoreC.release();
        }
    }
    public void printC() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            semaphoreC.acquire();
            System.out.println("C");
            semaphoreA.release();
        }
    }

    public static void main(String[] args) {
        PrintABC printABC = new PrintABC();

        new Thread(() -> {
            try {
                printABC.printA();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        new Thread(() -> {
            try {
                printABC.printB();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        new Thread(() -> {
            try {
                printABC.printC();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

}
