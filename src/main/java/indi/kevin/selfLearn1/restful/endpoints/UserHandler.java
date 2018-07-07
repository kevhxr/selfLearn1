package indi.kevin.selfLearn1.restful.endpoints;

import indi.kevin.selfLearn1.restful.model.User;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.apache.log4j.Logger;

@Path("/user")
@Produces(MediaType.TEXT_PLAIN)
public class UserHandler {

    final Logger logger = Logger.getLogger(UserHandler.class);

    @GET
    @Path("/test")
    public String serviceTest(){
        return "hey dude";
    }

    @GET
        @Path("/sayhi/{userId}/{pwd}")
    public String sayHi(@PathParam("userId") String userId, @PathParam("pwd") String pwd){
        User user = new User.Builder().userId(userId).pwd(pwd).build();
        logger.info("Say Hi for " + user.userInfo());
        return user.userInfo();
    }
}
