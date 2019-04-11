package com.example.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.function.Supplier;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.web.EndpointServlet;
import org.springframework.boot.actuate.endpoint.web.annotation.ServletEndpoint;
import org.springframework.stereotype.Component;

@SuppressWarnings("serial")
@Component
@ServletEndpoint(id = "servlettest")
public class ServletTestEndpoint extends HttpServlet implements Supplier<EndpointServlet> {

    @Autowired
    public ServletTestEndpoint() {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.println("REPONSE FROM A SERVLET ENDPOINT (ADMIN)");
    }

    @Override
    public EndpointServlet get() {
        return new EndpointServlet(ServletTestEndpoint.class);
    }
}
