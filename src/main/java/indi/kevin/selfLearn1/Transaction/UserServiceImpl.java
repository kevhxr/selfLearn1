package indi.kevin.selfLearn1.Transaction;

import indi.kevin.selfLearn1.Transaction.interfaces.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public void addUser() {
        System.out.println("add user");
    }

    @Override
    public String updateUser(String userName) {
        System.out.println("update user");
        return "updated to " + userName;
    }

    @Override
    public void deleteUser() {
        System.out.println("delete user");
        int i = 1/0;
       // throw new NullPointerException();
    }
}
