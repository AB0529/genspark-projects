package com.ab0529.DogFacts.models;

import org.springframework.stereotype.Component;

@Component("fact")
public class Fact {

    private String text;
    private int id;

    public Fact() {}
    public Fact(int id) {
        this.id = id;
    }
    public Fact(String text) {
        this.text = text;
    }
    public Fact(int id, String text) {
        this.text = text;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return String.format("Fact #%d: %s", id, text);
    }
}
