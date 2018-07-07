package indi.kevin.selfLearn1.common;

import indi.kevin.selfLearn1.servlets.HelloServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;
import org.eclipse.jetty.servlet.ServletContextHandler;

import java.net.InetSocketAddress;

public class JettyHelper {

    private final String port;
    private final String host;
    private Server jettyServer;

    public JettyHelper(String port, String host){
        this.port = port;
        this.host = host;
    }

    public void start(){

        InetSocketAddress address = new InetSocketAddress(host,Integer.parseInt(port));
        jettyServer = new Server(address);


        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
        context.setContextPath("/");
        context.addServlet(HelloServlet.class,"/hello");
        ServletHolder jerseyServlet = context.addServlet(ServletContainer.class, "/*");
        jerseyServlet.setInitOrder(10);
        jerseyServlet.setInitParameter("jersey.config.server.provider.packages",
                "indi.kevin.selfLearn1.restful.endpoints");

        jettyServer.setHandler(context);

        try {
            jettyServer.start();
            jettyServer.join();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            jettyServer.destroy();
        }
    }
}
