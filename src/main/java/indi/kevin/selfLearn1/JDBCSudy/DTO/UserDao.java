package indi.kevin.selfLearn1.JDBCSudy.DTO;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDao extends JdbcDaoSupport {
/*    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }*/



    public void update(User user){
        String sql = "update user set username=?, password=? where id = ?";
        Object[] args = {user.getUserName(),user.getPassword(),user.getId()};
        this.getJdbcTemplate().update(sql,args);

    }



    public List<User> getAll(){
        RowMapper<User> rowMapper = new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int i) throws SQLException {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUserName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                return user;
            }
        };
        List<User> users =  this.getJdbcTemplate().query("select * from user",rowMapper);
        return users;
    }
}
