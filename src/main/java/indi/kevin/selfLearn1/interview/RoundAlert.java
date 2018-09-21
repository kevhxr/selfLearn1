package indi.kevin.selfLearn1.interview;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RoundAlert {

    static AtomicInteger mainNum = new AtomicInteger(1);


    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Condition conOne = lock.newCondition();
        Condition conTwo = lock.newCondition();
        Condition conThree = lock.newCondition();
        Thread t1 = new Thread(new Counter(lock, conOne, conTwo, 1), "t1");
        Thread t2 = new Thread(new Counter(lock, conTwo, conThree, 2), "t2");
        Thread t3 = new Thread(new Counter(lock, conThree, conOne, 3), "t3");
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        System.out.println("done");
    }

    static class Counter implements Runnable {

        private Condition holdCondition;
        private Condition nextCondition;
        private int countNum;
        private Lock lock;

        public Counter(Lock lock, Condition holdCondition, Condition nextCondition, int countNum) {
            this.lock = lock;
            this.countNum = countNum;
            this.holdCondition = holdCondition;
            this.nextCondition = nextCondition;
        }

        @Override
        public void run() {
            for (int i = 0; i < 2; i++) {
                lock.lock();
                while (mainNum.get() != countNum) {
                    try {
                        holdCondition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " " + mainNum.get());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(countNum == 3){
                    mainNum.set(1);
                    System.out.println("=======================");
                }else {
                    mainNum.getAndIncrement();
                }
                nextCondition.signalAll();
                lock.unlock();
            }
        }
    }
}

