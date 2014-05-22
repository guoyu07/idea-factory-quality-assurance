package pl.edu.knbit.qa.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.edu.knbit.qa.services.DictionaryServiceClient;

import java.util.Map;

public class Client {

    public static void runAppClient() {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        DictionaryServiceClient dictionaryServiceClient = (DictionaryServiceClient) context.getBean("dictionaryClient");

        long timestamp = System.currentTimeMillis();

        dictionaryServiceClient.addNewEntry("Key@Client" + timestamp, "Value@Client" + timestamp);

        for (Map.Entry<String, String> entry : dictionaryServiceClient.getDictionary().entrySet() ) {
            System.out.println( entry.getKey() + " => " + entry.getValue() );
        }
    }

    public static void main( String[] args ) {
        try {
            runAppClient();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
