package io.terence.hibernatedetached.controllers;

import io.terence.hibernatedetached.entities.Test;
import io.terence.hibernatedetached.repositories.TestRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    private final TestRepository testRepository;

    public TestController(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @PostMapping("/saveTest")
    public ResponseEntity<String> setId(@RequestBody Test test){
        Test test1 = testRepository.save(test);
        return ResponseEntity.ok(test1.toString());
    }
}
