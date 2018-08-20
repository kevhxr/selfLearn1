package indi.kevin.selfLearn1.AOPStudy.fullAutoAOP;

import indi.kevin.selfLearn1.AOPStudy.interfaces.UserService;
import org.springframework.stereotype.Service;

@Service("userServiceAnoId")
public class UserServiceAno implements UserService {
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
    }
}
