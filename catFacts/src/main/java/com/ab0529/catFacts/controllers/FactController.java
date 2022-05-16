package com.ab0529.catFacts.controllers;

import com.ab0529.catFacts.models.Fact;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Random;

/**
 * Object representing a cat fact
 */
public class FactController {
    private String filename;
    private HashSet<Fact> facts;

    public FactController(String filename) {
        this.filename = filename;
        facts = new HashSet<>();

        populateFacts();
    }

    /**
     * @return a random fact from facts set
     */
    public Fact randomFact() {
        return facts.stream()
                .skip(
                        new Random()
                        .nextInt(facts.size()))
                .findFirst().orElse(null);
    }

    /**
     * Populates the facts hashset with facts from the filepath
     */
    private void populateFacts() {
        BufferedReader reader;

        try {
            reader = new BufferedReader( new FileReader(filename));
            String line;
            int i = 0;

            while((line = reader.readLine()) != null) {
                facts.add(new Fact(i, line));
                i++;
            }

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public HashSet<Fact> getFacts() {
        return facts;
    }
}
