package indi.kevin.selfLearn1.common;

import indi.kevin.selfLearn1.restful.endpoints.JunkHandler;
import indi.kevin.selfLearn1.restful.endpoints.UserHandler;
import indi.kevin.selfLearn1.servlets.HelloServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;
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

    public void startHandler() throws Exception{

        InetSocketAddress address = new InetSocketAddress(host,Integer.parseInt(port));
        jettyServer = new Server(address);

        ContextHandler contextHandler = new ContextHandler();
        contextHandler.setContextPath("/");
        contextHandler.setResourceBase(".");
        contextHandler.setClassLoader(Thread.currentThread().getContextClassLoader());
        jettyServer.setHandler(contextHandler);
        contextHandler.setHandler(new JunkHandler());
        jettyServer.start();
        jettyServer.join();
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
