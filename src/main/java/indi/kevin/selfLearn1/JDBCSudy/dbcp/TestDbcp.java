package indi.kevin.selfLearn1.JDBCSudy.dbcp;

import indi.kevin.selfLearn1.JDBCSudy.DTO.User;
import indi.kevin.selfLearn1.JDBCSudy.DTO.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.List;

public class TestDbcp {

    public static void main(String[] args){
        User user = new User();
        user.setId(1);
        user.setUserName("James");
        user.setPassword("123321");
        ApplicationContext applicationContext =
                new FileSystemXmlApplicationContext("src/main/WEB-INF/jdbcTest.xml");
        UserDao userDao = (UserDao) applicationContext.getBean("userDaoId");
        /*  userDao.update(user);*/
        List<User> users = userDao.getAll();
        for(User user1 : users){
            System.out.println(user1.getUserName());
        }
    }


}
