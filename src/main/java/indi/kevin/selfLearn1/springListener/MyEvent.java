package indi.kevin.selfLearn1.springListener;

import org.springframework.context.ApplicationEvent;

public class MyEvent extends ApplicationEvent {

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;

    public void doLog(){
        System.out.println(message);
    }

    public MyEvent(Object source, String message) {
        super(source);
        this.setMessage(message);
    }
}
