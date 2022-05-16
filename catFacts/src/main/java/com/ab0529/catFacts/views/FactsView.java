package com.ab0529.catFacts.views;

import com.ab0529.catFacts.controllers.FactController;
import com.ab0529.catFacts.models.Fact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FactsView {
    FactController facts = new FactController(getClass().getClassLoader().getResource("facts.txt").getPath());

    @GetMapping("fact")
    public ResponseEntity getFact() {
        return new ResponseEntity<Fact>(facts.randomFact(), HttpStatus.OK);
    }
}
