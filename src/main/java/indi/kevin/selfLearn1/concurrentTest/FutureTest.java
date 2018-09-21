package indi.kevin.selfLearn1.concurrentTest;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class FutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> f2 = new FutureTask<>(()->{
            Thread.sleep(3000);
            return 1000;
        });
/*        new Thread(task).start();
        System.out.println(task.get());
        System.out.println("end");*/

        System.out.println("========================");

        ExecutorService executorService = Executors.newFixedThreadPool(2);

/*        Future<Integer> f = executorService.submit(()->{
            TimeUnit.MILLISECONDS.sleep(1000);
            return 500;
        });*/

        executorService.submit(f2);

        TimeUnit.MILLISECONDS.sleep(1000);
        if(f2.isDone()){
            System.out.println(f2.get());
        }else{
            System.out.println("going to cancel f2 since it died for too long: "+f2.cancel(false));
        }
        System.out.println("f2 been done: "+f2.isDone());
/*
        System.out.println("f1:"+f.isDone()+" f2:"+f2.isDone());
        System.out.println("f2 res:"+f2.get());
        System.out.println("f1 res:"+f.get());
        System.out.println("f1:"+f.isDone()+" f2:"+f2.isDone());*/
        executorService.shutdown();

    }
}



class CachedData {
    Object data;
    volatile boolean cacheValid;
    ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    void processCachedData() {
        rwl.readLock().lock();
        //step1 @hxx 任何人都可以读数据,因为没人写，提高性能
        if (!cacheValid) {
            // @hxx 如果有缓存了，就不用去load数据库写缓存了，相当于if(cache.get(key) == null)
            rwl.readLock().unlock();
        }
        // @hxx 为什么 拿“写锁” 前要释放掉 “读锁”？？ 要判断没有人拿 “读锁” 才可以写，是这样实现读写互斥的？
        rwl.writeLock().lock();
        // @hxx 从这里开始，保证一次只有一个线程进来啦
        if (!cacheValid) {
            // Recheck state because another thread might have acquired // write lock and changed state before we did.
           // data = ...
            cacheValid = true;
        }
        // @hxx，我先拿个读锁，哈哈， 在我释放读锁之前，谁也别想拿写锁，因为写锁拿到的前提是没有人拿读锁
        rwl.readLock().lock();
        rwl.writeLock().unlock();
        // step2 @hxx 我在读数据不怕别人写，真的爽！
       // use(data);
        rwl.readLock().unlock();
    }
}
