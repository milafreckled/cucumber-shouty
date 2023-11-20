package io.cucumber.shouty;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private int location;
    public List<String> messages = new ArrayList<String>();
    private Network network;

    public Person(Network network) {
    }
    public Person(Network network, int location) {
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
