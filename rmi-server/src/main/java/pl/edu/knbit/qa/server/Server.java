package pl.edu.knbit.qa.server;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.remoting.rmi.RmiServiceExporter;

public class Server {
    public static void runAppServer() {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
    }

    public static void main( String[] args ) {

        try {
            runAppServer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
