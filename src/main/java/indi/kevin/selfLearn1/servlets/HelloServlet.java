package indi.kevin.selfLearn1.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response){
        try {
            System.out.println(request.getRequestURI());
            response.getWriter().println("Hello waorld");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
