package io.cucumber.shouty;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {
    @Given("Lucy is located {int} meters from Sean")
    public void lucyIsLocatedMetersFromSean(int arg0) {
    }

    @When("Sean shouts {string}")
    public void seanShouts(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Lucy hears Sean's message")
    public void lucyHearsSeanSMessage() {
    }
}
