package io.cucumber.shouty;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class StepDefinitions {
//    private Person lucy;
//    private Person sean;
    private static final int DEFAULT_RANGE = 100;
    private String messageFromSean;
    private Network network = new Network(DEFAULT_RANGE);
    private HashMap<String, Person> people;
    @Before
    public void createNetwork(){
//        network = new Network(DEFAULT_RANGE));
        people = new HashMap<>();
    }
    @Given("a person named {word} is located at {int}")
    public void aPersonNamedIsLocatedAt(String name, int range) {
        people.put(name, new Person(network, range));
    }
    @Given("the range is {int}")
    public void theRangeIs(int range) {
        network = new Network(range);
    }

    @When("Sean shouts")
    public void seanShouts() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        people.get("Sean").shout("Hello friends!");
    }
    @When("Sean shouts {string}")
    public void seanShouts(String message) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        people.get("Sean").shout(message);
        messageFromSean = message;
    }

    @Then("Lucy should hear a shout")
    public void lucyShouldHearAShout() {
        assertEquals(1, people.get("Lucy").getMessagesHeard().size());
    }

    @Then("Larry should not hear a shout")
    public void larryShouldNotHearAShout() {
        assertEquals(0, people.get("Larry").getMessagesHeard().size());
    }

    @And("a person named {word}")
    public void aPersonNamedSean(String name) {
        people.put(name, new Person(network, 0));
    }
}
