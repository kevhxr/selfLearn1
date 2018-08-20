package indi.kevin.selfLearn1.AOPStudy.halfAutoProxy;

import indi.kevin.selfLearn1.AOPStudy.interfaces.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public void addUser() {
        System.out.println("add user");
    }

    @Override
    public String updateUser(String userName) {
        System.out.println("update user");
        return userName;
    }

    @Override
    public void deleteUser() {
        System.out.println("delete user");

    }
}
