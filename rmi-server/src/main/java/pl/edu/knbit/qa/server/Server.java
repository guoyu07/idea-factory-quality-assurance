package pl.edu.knbit.qa.server;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Server {
    public static void runAppServer() {
        new ClassPathXmlApplicationContext("rmi-server.xml");
    }

    public static void main( String[] args ) {
        try {
            runAppServer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
