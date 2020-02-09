package indi.kevin.selfLearn1.concurrentTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicTest {


    @Test
    public void testStampRef() {

        AtomicStampedReference<Integer> asf = new AtomicStampedReference<>(0, 0);

        ExecutorService service = Executors.newFixedThreadPool(5);

        List<Future> submits = new ArrayList<>();

        for (int i = 1; i < 3; i++) {
            int oldStr = i - 1;
            int newStr = i;
            submits.add(service.submit(() -> {
                Thread.currentThread().setName("T" + newStr);
                String tName = "[" + Thread.currentThread().getName() + "]";
                System.out.println(tName +
                        "before:" + asf.getReference() + ":" + asf.getStamp());
                //boolean b = asf.compareAndSet(asf.getReference(), newStr, asf.getStamp(), asf.getStamp() + 1);
                if (newStr < 2) {
                    try {
                        Thread.currentThread().sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                boolean b;
                while (!(b = asf.compareAndSet(oldStr, newStr, asf.getStamp(), asf.getStamp() + 1))) {
                    try {
                        System.out.println(tName + "sleep");
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println(tName +
                        "after: " + b + ": " + asf.getReference() + ":" + asf.getStamp());
                // asf.set(newStr,asf.getStamp()+1);
            }));
        }
        submits.stream().forEach(a -> {
            try {
                a.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
        System.out.println(asf.getStamp() + " " + asf.getReference());
        service.shutdown();
    }
}
