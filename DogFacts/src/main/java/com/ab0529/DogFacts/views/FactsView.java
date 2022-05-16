package com.ab0529.DogFacts.views;

import com.ab0529.DogFacts.controllers.FactController;
import com.ab0529.DogFacts.models.Fact;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FactsView {
    FactController facts = new FactController(getClass().getClassLoader().getResource("facts.txt").getPath());

    @GetMapping("fact")
    public ResponseEntity getFact() {
        return new ResponseEntity<Fact>(facts.randomFact(), HttpStatus.OK);
    }
    @PostMapping("add")
    public ResponseEntity addNewFact(@RequestBody Fact f) {
        facts.addFact(f);

        return new ResponseEntity<Fact>(f, HttpStatus.CREATED);
    }
}
