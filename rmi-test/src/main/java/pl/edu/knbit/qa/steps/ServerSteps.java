package pl.edu.knbit.qa.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.knbit.qa.services.SharedStepsDataService;

import java.util.Map;

@Service
public class ServerSteps {

    @Autowired
    private SharedStepsDataService sharedStepsDataService;

    @Given("initialized server")
    public void givenInitializedClient() {
        System.out.println( "inicjalizacja serwera" );
    }

}
