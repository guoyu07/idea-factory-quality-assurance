package pl.edu.knbit.qa.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.knbit.qa.services.DictionaryServiceClient;

import java.util.Map;

import static junit.framework.TestCase.assertTrue;

@Service
public class ClientSteps {

    @Autowired
    private DictionaryServiceClient dictionaryServiceClient;

    @Given("initialized client")
    public void givenInitializedClient() {
        System.out.println( "inicjalizacja klienta" );

        for (Map.Entry<String, String> entry : dictionaryServiceClient.getDictionary().entrySet() ) {
            System.out.println( entry.getKey() + " => " + entry.getValue() );
        }
    }

    @When("added new entry to dictionary")
    public void whenSendSthToServer() {
        System.out.println( "dodajemy coś do słownika" );

        assertTrue(dictionaryServiceClient.addNewEntry("ala" + System.currentTimeMillis(), "makota"));

        for (Map.Entry<String, String> entry : dictionaryServiceClient.getDictionary().entrySet() ) {
            System.out.println( entry.getKey() + " => " + entry.getValue() );
        }
    }

    @Then("new entry was added to dictionary")
    public void thenResponseIsReceived() {
        System.out.println( "jakaś asercja" );

        for (Map.Entry<String, String> entry : dictionaryServiceClient.getDictionary().entrySet() ) {
            System.out.println( entry.getKey() + " => " + entry.getValue() );
        }
    }

}
