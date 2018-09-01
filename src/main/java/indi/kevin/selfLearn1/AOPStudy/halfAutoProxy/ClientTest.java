package indi.kevin.selfLearn1.AOPStudy.halfAutoProxy;

import indi.kevin.selfLearn1.AOPStudy.interfaces.UserService;

public class ClientTest {

    public static void main(String[] args){
        UserService userService = (UserService) new CglibProxy().createProxyObject(new UserServiceImpl());
        userService.addUser();
    }
}
