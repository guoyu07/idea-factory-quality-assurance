package pl.edu.knbit.qa.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.stereotype.Service;

@Service
public class ClientSteps {

    @Given("initialized client")
    public void givenInitializedClient() {
        System.out.println( "inicjalizacja klienta" );
    }

    @When("send sth to server")
    public void whenSendSthToServer() {
        System.out.println( "warunek when" );
    }

    @Then("response is received")
    public void thenResponseIsReceived() {
        System.out.println( "jakaś asercja" );
    }

}
