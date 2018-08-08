package indi.kevin.selfLearn1.concurrentTest.TestQuestions;

import java.util.LinkedList;
import java.util.Random;

public class ConcurrentQueue {

    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(3);
        System.out.println(ll.remove(0));
        MyQueue myQueue = new MyQueue();
        Thread threadGet = new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                System.out.println(i+": =============Get from linkedList:" + myQueue.get(i));
            }
        });

        Thread threadAdd = new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                int a = new Random().nextInt(10);
                myQueue.add(a);
                System.out.println(i+": insert into linkedList:" + a);
            }
        });

        threadAdd.start();
        threadGet.start();
    }
}

class MyQueue {
    int sum = 10;
    LinkedList<Integer> linkedList = new LinkedList<>();

    public int get(int i) {
       // System.out.println("start to get size: "+linkedList.size());
        synchronized (linkedList) {
            while (linkedList.size() <= 0) {
                System.out.println(i+" turns to wait ------ to get");
                try {
                   linkedList.wait();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            linkedList.notify();
            return linkedList.remove(0);
        }

    }

    public void add(int a) {
        synchronized (linkedList) {
            while (linkedList.size() >= sum) {
                try {
                    System.out.println("wait ------ to add");
                    linkedList.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            linkedList.notify();
            linkedList.add(linkedList.size(), a);
        }
    }
}