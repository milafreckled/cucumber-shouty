package io.cucumber.shouty;

import java.util.ArrayList;
import java.util.List;

public class Person {
    public int getLocation() {
        return location;
    }

    private int location;
    public static List<String> messages = new ArrayList<String>();
    private Network network;

    public Person(Network network) {
    }
    public Person(Network network, int location) {
        this.network = network;
        this.location = location;
    }

    public void hear(String message){
        messages.add(message);
    }
    public void shout(String message){
            network.broadcast(message, getLocation());
    }
    public List<String> getMessagesHeard(){
//        List<String> result = new ArrayList<String>();
//        result.add("free bagels at Sean's");
        return messages;
    }
}
