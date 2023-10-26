package io.cucumber.shouty;

import java.util.ArrayList;
import java.util.List;

public class Person {
    public static List<String> messages = new ArrayList<String>();
    public void moveTo(int distance){

    }
    public void shout(String message){
            messages.add(message);
    }
    public List<String> getMessagesHeard(){
//        List<String> result = new ArrayList<String>();
//        result.add("free bagels at Sean's");
        return messages.subList(messages.size()-1, messages.size());
    }
}
