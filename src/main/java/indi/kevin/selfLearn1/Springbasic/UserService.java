package indi.kevin.selfLearn1.Springbasic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class UserService {

    public User user;
    public User getUser() {
        return user;
    }
    @Autowired
    public void setUser(@Qualifier("user01") User user) {
        this.user = user;
    }

    @Override
    public String toString(){
        return user.getUserName()+" is "+user.getAge()+" years old";
    }

    public void init(){
        System.out.println("init");
    }

    public void destory(){
        System.out.println("destory");
    }
}
