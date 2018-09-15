package indi.kevin.selfLearn1.concurrentTest;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WorkThreadPool {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newWorkStealingPool(2);
        //ExecutorService service = Executors.newFixedThreadPool(2);
        CountDownLatch latch = new CountDownLatch(5);
        long start = System.currentTimeMillis();
        service.execute(new WorkExecutorRunnable(1500,latch));
        service.execute(new WorkExecutorRunnable(5000,latch));
        service.execute(new WorkExecutorRunnable(2000,latch));
        service.execute(new WorkExecutorRunnable(3000,latch));
        service.execute(new WorkExecutorRunnable(1000,latch));
        latch.await();
        System.out.println("done: took "+(System.currentTimeMillis()-start));
        service.shutdown();
    }
}


class WorkExecutorRunnable implements Runnable{

    private final int time;
    CountDownLatch latch;
    public WorkExecutorRunnable(int time, CountDownLatch latch){
        this.time = time;
        this.latch = latch;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" has done sleep after "+time+" miliseconds");
        latch.countDown();
    }
}
