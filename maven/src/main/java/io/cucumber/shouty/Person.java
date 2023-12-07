package io.cucumber.shouty;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private int location;
    public List<String> messages = new ArrayList<String>();
    private Network network;

    public void takeCredits(int amount){
        this.credits -= amount;
    }

    public int getCredits() {
        return credits;
    }

    public void buyCredits(int amount) {
        this.credits += amount;
    }

    private int credits;
    public Person(Network network) {
    }
    public Person(String name, Network network, int location) {
        this.name = name;
        this.network = network;
        this.location = location;
    }
    public int getLocation() {
        return location;
    }
    public void hear(String message){
        messages.add(message);
    }
    public void shout(String message){
            network.broadcast(message, getLocation());
    }
    public List<String> getMessagesHeard(){
        System.out.println("Messages heard: " + messages.toString());
        return messages;
    }
}
