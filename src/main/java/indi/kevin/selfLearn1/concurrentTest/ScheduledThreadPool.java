package indi.kevin.selfLearn1.concurrentTest;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPool {

    public static void main (String[] args){
        ScheduledExecutorService service = Executors.newScheduledThreadPool(3);
        service.scheduleAtFixedRate(new ScheduleAtFixedRate(1000),0,500,TimeUnit.MILLISECONDS);
        service.scheduleAtFixedRate(new ScheduleAtFixedRate(5000),0,500,TimeUnit.MILLISECONDS);
    }
}

class ScheduleAtFixedRate implements Runnable{

    private final int time;
    public ScheduleAtFixedRate(int time){
        this.time = time;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" has done sleep after "+time+" miliseconds");
    }
}
