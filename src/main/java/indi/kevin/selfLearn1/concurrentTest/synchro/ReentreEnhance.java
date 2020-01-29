package indi.kevin.selfLearn1.concurrentTest.synchro;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.LockSupport;

/**
 * AbstractQueuedSynchronizer
 * protected final boolean tryAcquire(int acquires)
 * hasQueuedPredecessors
 * check if lock been owned by other
 * check if it need to be queued
 * if yes then add to queue (add new Node)
 * acquireQueued(addWaiter(Node.EXCLUSIVE), arg))
 *
 * ws = 0 originally
 * thread cannot set its ws since it cant know its already sleep
 * ws = -1 represent been slept
 * this set is done when the next thread enqueue
 *
 * 持有锁的线程不参与排队
 *
 */
public class ReentreEnhance {


    static volatile int status = 0;
    static Queue<Thread> parkQueue;

    static {
        parkQueue = new LinkedList<>();
    }

    void lock(){
        while(!compareAndSet(0,1)){
            park();
        }
        unlock();
    }

    private boolean compareAndSet(int i, int j) {
        return false;
    }

    static void park() {
        parkQueue.add(Thread.currentThread());
        //releaseCpu();
    }

    static void unlock() {
        status = 0;
        lock_notify();

    }

    static void lock_notify() {
        Thread t = parkQueue.peek();
        LockSupport.unpark(t);
    }
}
