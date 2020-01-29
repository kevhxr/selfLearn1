package indi.kevin.selfLearn1.concurrentTest.synchro;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyContainer {

    private final LinkedList<String> list = new LinkedList<>();
    private final int MAX = 10;

    private int count = 0;
    private static ReentrantLock lock = new ReentrantLock();
    private static Condition producer = lock.newCondition();
    private static Condition consumer = lock.newCondition();


    public void put(String stuff) {
        try {
            lock.lock();
            while (list.size() > MAX) {
                producer.await();
            }
            list.add(stuff);
            ++count;
            System.out.println("[producer] -- count:" + count + " put:" + stuff + " " +
                    getListStr(list));
            consumer.signalAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();

        }
    }

    private String getListStr(LinkedList<String> list) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[ ");
        for (String str : list) {
            stringBuilder.append(str + ", ");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void get() {
        String stuff;
        try {
            lock.lock();
            while (list.size() == 0) {
                consumer.await();
            }
            stuff = list.removeFirst();
            --count;
            System.out.println("[consumer] -- count:" + count + " get:" + stuff + " " +
                    getListStr(list));
            producer.signalAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();

        }
    }

    public static void main(String[] args) {
        MyContainer myContainer = new MyContainer();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                int sleepSec = new Random().nextInt(1);
                try {
                    Thread.sleep(sleepSec * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                myContainer.get();
            }).start();
            new Thread(() -> {
                int sleepSec = new Random().nextInt(3);
                try {
                    Thread.sleep(sleepSec * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                myContainer.put(new Random().nextInt(10) + "");
            }).start();
        }
    }
}
