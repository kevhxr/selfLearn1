package indi.kevin.selfLearn1.concurrentTest;

import java.util.concurrent.*;

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
