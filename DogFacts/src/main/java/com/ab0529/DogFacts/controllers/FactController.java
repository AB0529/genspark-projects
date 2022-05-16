package com.ab0529.DogFacts.controllers;

import com.ab0529.DogFacts.models.Fact;

import java.io.*;
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

    public void addFact(Fact f) {
        try(FileWriter fw = new FileWriter(filename, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw)) {

            out.println(f.getText());
            populateFacts();

        } catch (IOException e) {
            e.printStackTrace();
        }

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
