package io.cucumber.shouty;

import java.util.ArrayList;
import java.util.List;

public class Network {
    private final List<Person> people = new ArrayList<>();
    private final int range;

    public Network(int range) {
        this.range = range;
    }

    public void subscribe(Person p) {
        people.add(p);
    }

    public void broadcast(String message, int shouterLocation) {
        for (Person listener : people) {
            if (Math.abs(listener.getLocation() - shouterLocation) <= range) {
                listener.hear(message);
            }
        }
    }
}
