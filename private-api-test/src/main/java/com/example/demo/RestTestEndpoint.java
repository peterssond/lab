package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.web.annotation.RestControllerEndpoint;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@RestControllerEndpoint(id = "resttest")
public class RestTestEndpoint {

    @Autowired
    public RestTestEndpoint() {

    }

    @GetMapping(path = "/test1")
    public String test1() {
        return "REPONSE FROM TEST1 REST ENDPOINT (ADMIN)";
    }

    @GetMapping(path = "/test2")
    public String test2() {
        return "REPONSE FROM TEST2 REST ENDPOINT (ADMIN)";
    }

    @GetMapping(path = "/test3")
    public String test3() {
        return "REPONSE FROM TEST2 REST ENDPOINT (ADMIN), MOOOORE";
    }
}
