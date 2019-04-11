package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/internalapi")
public class TestInternalRest {

    @Autowired
    public TestInternalRest() {
    }

    @GetMapping(path = "/test")
    public String test() {
        return "PROTECTED TEST OK (STANDARD)";
    }

    @GetMapping(path = "/test2")
    public String test2() {
        return "WE NEED THIS ENDPOINT ASWELL";
    }
}
