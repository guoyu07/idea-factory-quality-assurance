package pl.edu.knbit.qa.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.knbit.qa.services.DictionaryServiceClient;
import pl.edu.knbit.qa.services.SharedStepsDataService;

import java.util.Map;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasEntry;

@Service
public class ClientSteps {

    @Autowired
    private DictionaryServiceClient dictionaryServiceClient;

    @Autowired
    private SharedStepsDataService sharedStepsDataService;

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

        long timestamp = System.currentTimeMillis();
        String key = "Key@TestAkceptacyjny" + timestamp;
        String value = "Value@TestAkceptacyjny" + timestamp;

        sharedStepsDataService.putData("key", key);
        sharedStepsDataService.putData("value", value);

        assertTrue(dictionaryServiceClient.addNewEntry(key, value));

        for (Map.Entry<String, String> entry : dictionaryServiceClient.getDictionary().entrySet() ) {
            System.out.println( entry.getKey() + " => " + entry.getValue() );
        }
    }

    @Then("new entry was added to dictionary")
    public void thenNewEntryWasAddedToDictionary() {
        System.out.println( "jakaś asercja" );

        String key = (String)sharedStepsDataService.getData("key");
        String value = (String)sharedStepsDataService.getData("value");

        assertThat(dictionaryServiceClient.getDictionary(), hasEntry(key, value));
    }

}
