package indi.kevin.selfLearn1.springListener;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"indi.kevin.selfLearn1.springListener"})
public class EventConfig {
    public static void main(String[] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EventConfig.class);
        MyPublisher myPublisher = context.getBean(MyPublisher.class);
        myPublisher.publish();
        context.close();
    }
}
