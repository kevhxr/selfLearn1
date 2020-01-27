package indi.kevin.selfLearn1.concurrentTest.synchro;

import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.locks.ReentrantLock;


/**
 * jvm64位 对象大小为8byte的倍数，
 * 不够就填充空byte 叫做数据对齐
 * 锁定的是对象头
 *
 */
public class SynchroTest {
    static Player a = new Player();
    static ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {
        System.out.println(ClassLayout.parseInstance(a).toPrintable());
    }
    public static void lockTest(){
        reentrantLock.lock();
        System.out.println("sdas");
        reentrantLock.unlock();
        synchronized (a){
            System.out.println("xsa");
            System.out.println("xsaasdads");
        }
    }
}

