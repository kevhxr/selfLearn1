package indi.kevin.selfLearn1.springListener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MyListener implements ApplicationListener<MyEvent> {


    @Override
    public void onApplicationEvent(MyEvent myEvent) {
        String message = myEvent.getMessage();
        System.out.println("myListener has received the message from publisher: "+message);
    }
}
