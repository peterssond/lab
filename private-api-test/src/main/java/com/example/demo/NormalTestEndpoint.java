package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "normaltest")
public class NormalTestEndpoint {

    @Autowired
    public NormalTestEndpoint() {

    }

    @ReadOperation
    public String test() {
        return "REPONSE FROM A NORMAL REST ENDPOINT (ADMIN)";
    }
}
