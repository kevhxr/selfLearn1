package indi.kevin.selfLearn1.restful.model;

public class User {

    private String userId;
    private String pwd;

    public User(){
    }

    public User(String userId){
        this.userId = userId;
    }

    public String getPwd(){
        return pwd;
    }

    public String getId() {
        return userId;
    }

    public String userInfo(){
        return "user Id is:" + userId + ", password is:" + pwd;
    }

    public static class Builder{
        private User user;

        public Builder(){
            user = new User();
        }

        public Builder userId(String userId){
            user.userId = userId;
            return this;
        }

        public Builder pwd(String pwd){
            user.pwd = pwd;
            return this;
        }

        public User build(){
            return user;
        }
    }
}
