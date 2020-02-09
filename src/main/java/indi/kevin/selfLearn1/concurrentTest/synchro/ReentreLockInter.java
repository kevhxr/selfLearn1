package indi.kevin.selfLearn1.concurrentTest.synchro;

import java.util.concurrent.locks.ReentrantLock;

public class ReentreLockInter {

    static ReentrantLock lock = new ReentrantLock();


    public static void main(String[] args) {
        Thread t1 = new Thread(() -> syncTest());
        Thread t2 = new Thread(() -> syncTest());

        t1.setName("t1");
        t2.setName("t2");

        Thread.currentThread().interrupt();
        System.out.println(Thread.interrupted());
        System.out.println(Thread.interrupted());
        System.out.println(Thread.interrupted());


        t1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("start to interrupt by main");
        t2.interrupt();

    }

    public static void syncTest() {
        String name = Thread.currentThread().getName();
/*        if (name == "t2") {
            Thread.currentThread().interrupt();
        }*/
        try {
            lock.lock();
            lock.lockInterruptibly();
        } catch (Exception e) {
            System.out.println("been interrupted!!!!");
            System.out.println(e.toString());
        }

        System.out.println(name);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        lock.unlock();
        System.out.println(Thread.currentThread().getName() + " just releases the lock");
    }
}


/**
 *
 *         final boolean nonfairTryAcquire(int acquires) {
 *             final Thread current = Thread.currentThread();
 *             int c = getState();
 *             if (c == 0) {
 *                 if (compareAndSetState(0, acquires)) {
 *                     setExclusiveOwnerThread(current);
 *                     return true;
 *                 }
 *             }
 *             else if (current == getExclusiveOwnerThread()) {
 *                 int nextc = c + acquires;
 *                 if (nextc < 0) // overflow
 *                     throw new Error("Maximum lock count exceeded");
 *                 setState(nextc);
 *                 return true;
 *             }
 *             return false;
 *         }
 *
 *
 *
 *         protected final boolean tryAcquire(int acquires) {
 *             final Thread current = Thread.currentThread();
 *             int c = getState();
 *             if (c == 0) {
 *                 if (!hasQueuedPredecessors() &&
 *                     compareAndSetState(0, acquires)) {
 *                     setExclusiveOwnerThread(current);
 *                     return true;
 *                 }
 *             }
 *             else if (current == getExclusiveOwnerThread()) {
 *                 int nextc = c + acquires;
 *                 if (nextc < 0)
 *                     throw new Error("Maximum lock count exceeded");
 *                 setState(nextc);
 *                 return true;
 *             }
 *             return false;
 *         }
 *
 */
