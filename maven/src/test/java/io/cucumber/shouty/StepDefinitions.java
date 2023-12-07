package io.cucumber.shouty;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.Transpose;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.shouty.support.ShoutyWorld;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class StepDefinitions {
    private final ShoutyWorld world;

    public StepDefinitions(ShoutyWorld world){
        this.world = world;
    }

//    private HashMap<String, Person> people;

    @Given("Sean has bought {int} credits")
    public void seanHasBoughtCredits(int arg0) {
    }

    @And("{person} should have {int} credits")
    public void seanShouldHaveCredits(Person person) {
    }


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

//    @Before
//    public void createNetwork(){
//        people = new HashMap<String, Person>();
//    }

    @Given("people are located at")
    public void people_are_located_at(@Transpose List<Whereabouts> dataTable) {
        for (Whereabouts personData : dataTable){
            Person p = new Person(personData.name, world.network, personData.location);
            world.people.put(personData.name, p);
            world.network.subscribe(p);
        }
    }

//    @Given("a person named {word} is located at {int}")
//    public void aPersonNamedIsLocatedAt(String name, int range) {
//        people.put(name, new Person(network, range));
//    }
    @Given("the range is {int}")
    public void theRangeIs(int range) {
        world.network = new Network(range);
    }

    @When("Sean shouts")
    public void seanShouts() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        world.people.get("Sean").shout("Hello friends!");
    }
    @When("Sean shouts {string}")
    public void seanShouts(String message) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        world.people.get("Sean").shout(message);
    }
    @When("{person} shouts the following message")
    public void seanShoutsTheFollowingMessage(Person person, String message) {
        world.shout(person, message);
    }
    @When("{person} shouts {int} long messages")
    public void sean_shouts_some_long_messages(Person person, int messages) throws Throwable {
        String longMessage = String.join("\n", "This is a long message,", "that is not exceeding 180 characters limit");
        for (int i = 0; i<messages; i++) {
            world.shout(person, longMessage);
        }
    }
    @And("{person} shouts {int} messages containing word {string}")
    public void seanShoutsMessagesContainingWord(Person person, int messages, String word) {
        for (int i = 0; i<messages; i++) {
            world.shout(person,"Some message"+word);
        }
    }

    @When("{person} shouts {int} over-long messages")
    public void sean_shouts_some_over_long_messages(Person person, int messages){
        String baseMessage = "A message from Sean that is 181 characters long";
        String padding = "x";
        String overLongMessage = baseMessage + padding.repeat(181 - baseMessage.length());
        for (int i = 0; i<messages; i++) {
            world.shout(person, overLongMessage);
        }
    }
    @Then("Lucy should hear a shout")
    public void lucyShouldHearAShout() {
        assertEquals(1, world.people.get("Lucy").getMessagesHeard().size());
    }

    @Then("{word} should not hear a shout")
    public void someoneShouldNotHearAShout(String name) {
        assertEquals(0, world.people.get(name).getMessagesHeard().size());
    }
    @Then("Lucy should hear following shouts")
    public void lucyShouldHearFollowingShouts(io.cucumber.datatable.DataTable expectedMessages) {
        List<List<String>> actualMessages = new ArrayList<List<String>>();
        List<String> heard = world.people.get("Lucy").getMessagesHeard();
        for (String message : heard){
            actualMessages.add(Collections.singletonList(message));
        }
        expectedMessages.diff(DataTable.create(actualMessages));
    }

    @And("a person named {word}")
    public void aPersonNamedSean(String name) {
        Person p= new Person(name, world.network, 0);
        world.people.put(name, p);
        world.network.subscribe(p);
    }
}
