package indi.kevin.selfLearn1.Springbasic;

public class User {

    public String userName;

    public int age;

    public User() {

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User(String userName,int age){
        this.userName = userName;
        this.age = age;
    }


}
