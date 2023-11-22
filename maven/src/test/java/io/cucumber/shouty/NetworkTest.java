package io.cucumber.shouty;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class NetworkTest {
    private int range = 100;
    private Network network = new Network(range);
    private String message = "Free bagels!";

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testSubscribe() {
    }

    @Test
    void testBroadcast() {
    }
//    public static <Person> Person mock(Class<Person> classToMock, String name);
    @Test
    public void does_not_broadcast_a_message_over_180_characters_even_if_listener_is_in_range(){
        int seanLocation = 0;
        char[] chars = new char[181];
        Arrays.fill(chars, 'x');
        String longMessage = String.valueOf(chars);
        Person laura = mock(Person.class, 50);
        network.subscribe(laura);
        network.broadcast(longMessage, seanLocation);
//        verify(laura, never()).hear(longMessage);
    }

    private Person mock(Class<Person> personClass, int location) {
        return new Person(network, location);
    }

    private Object never() {
        return null;
    }
}