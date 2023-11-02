package io.cucumber.shouty;

public class PersonBuilder {
    private String name;
    private Network n;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setN(Network n) {
        this.n = n;
        return this;
    }

//    public Person createPerson() {
//        return new Person(name);
//    }
}