package io.cucumber.shouty;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.DataTableType;
import io.cucumber.java.Transpose;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class StepDefinitions {
//    private Person lucy;
//    private Person sean;
    private static final int DEFAULT_RANGE = 100;
    private Network network = new Network(DEFAULT_RANGE);
    private HashMap<String, Person> people;


    static class Whereabouts{
        public String name;
        public Integer location;
        public Whereabouts(String name, Integer location){
            this.name = name;
            this.location = location;
        }
    }
    @DataTableType
    public Whereabouts defineWhereabouts(Map<String, String> entry){
        return new Whereabouts(entry.get("name"), Integer.parseInt(entry.get("location")));
    }

    @Before
    public void createNetwork(){
//        network = new Network(DEFAULT_RANGE));
        people = new HashMap<String, Person>();
    }

    @Given("people are located at")
    public void people_are_located_at(@Transpose List<Whereabouts> dataTable) {
        for (Whereabouts personData : dataTable){
            Person p = new Person(network, personData.location);
            people.put(personData.name, p);
            network.subscribe(p);
        }
    }

//    @Given("a person named {word} is located at {int}")
//    public void aPersonNamedIsLocatedAt(String name, int range) {
//        people.put(name, new Person(network, range));
//    }
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
    }
    @When("Sean shouts the following message")
    public void seanShoutsTheFollowingMessage(String message) {
        people.get("Sean").shout(message);
    }
    @Then("Lucy should hear a shout")
    public void lucyShouldHearAShout() {
        assertEquals(1, people.get("Lucy").getMessagesHeard().size());
    }

    @Then("{word} should not hear a shout")
    public void someoneShouldNotHearAShout(String name) {
        assertEquals(0, people.get(name).getMessagesHeard().size());
    }
    @Then("Lucy should hear following shouts")
    public void lucyShouldHearFollowingShouts(io.cucumber.datatable.DataTable expectedMessages) {
        List<List<String>> actualMessages = new ArrayList<List<String>>();
        List<String> heard = people.get("Lucy").getMessagesHeard();
        for (String message : heard){
            actualMessages.add(Collections.singletonList(message));
        }
        expectedMessages.diff(DataTable.create(actualMessages));
    }

    @And("a person named {word}")
    public void aPersonNamedSean(String name) {
        Person p= new Person(network, 0);
        people.put(name, p);
        network.subscribe(p);
    }
}
