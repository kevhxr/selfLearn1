package indi.kevin.selfLearn1.springListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MyPublisher {
    @Autowired
    ApplicationContext context;

    public void publish(){
        MyEvent myEvent = new MyEvent(this, "publish success");
        System.out.println("doing publish:"+myEvent);
        context.publishEvent(myEvent);
    }
}
