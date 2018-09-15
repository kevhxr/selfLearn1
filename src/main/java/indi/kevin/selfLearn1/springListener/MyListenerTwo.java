package indi.kevin.selfLearn1.springListener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MyListenerTwo implements ApplicationListener<MyEvent> {


    @Override
    public void onApplicationEvent(MyEvent myEvent) {
        System.out.println("==========Start listen");
        String message = myEvent.getMessage();
        System.out.println("==========myListenerTwo has received the message from publisher: "+message);
    }
}
