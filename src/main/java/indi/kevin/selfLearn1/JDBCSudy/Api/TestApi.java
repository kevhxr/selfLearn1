package indi.kevin.selfLearn1.JDBCSudy.Api;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestApi {

    public static void main(String[] args){

        //create connection pool
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        basicDataSource.setUrl("jdbc:mysql://localhost:3306/kevinSelfLearn");
        basicDataSource.setUsername("root");
        basicDataSource.setPassword("root");

        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(basicDataSource);

        jdbcTemplate.update("insert into user(username,password) values(?,?);","mike","1234");


    }
}
