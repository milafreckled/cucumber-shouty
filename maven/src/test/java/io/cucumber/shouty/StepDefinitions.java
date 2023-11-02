package io.cucumber.shouty;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Before;

import java.util.HashMap;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class StepDefinitions {
//    private Person lucy;
//    private Person sean;
    private String messageFromSean;
    private Network network;
    private HashMap<String, Person> people;
    @Before
    public void createNetwork(){
        network = new Network();
        people = new HashMap<>();
    }

    @Given("a person named {word}")
    public void aPersonNamed(String name) {
        people.put(name, new Person(network));
    }

    @When("Sean shouts {string}")
    public void seanShouts(String message) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        people.get("Sean").shout(message);
        messageFromSean = message;
    }

    @Then("Lucy hears Sean's message")
    public void lucyHearsSeanSMessage() {
        assertEquals(asList(messageFromSean), people.get("Lucy").getMessagesHeard());
    }
}
