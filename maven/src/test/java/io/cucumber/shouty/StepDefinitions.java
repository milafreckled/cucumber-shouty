package io.cucumber.shouty;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class StepDefinitions {
    private Person lucy;
    private Person sean;
    private String messageFromSean;
    @Given("Lucy is located {int} meters from Sean")
    public void lucyIsLocatedMetersFromSean(int distance) {
        lucy = new Person();
        sean = new Person();
        lucy.moveTo(distance);
        System.out.println("distance = " + distance);
    }

    @When("Sean shouts {string}")
    public void seanShouts(String message) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        sean.shout(message);
        messageFromSean = message;
    }

    @Then("Lucy hears Sean's message")
    public void lucyHearsSeanSMessage() {
        assertEquals(asList(messageFromSean), lucy.getMessagesHeard());
    }
}
