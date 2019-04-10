package com.example.demo;

import org.apache.catalina.connector.Connector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServerConnectorConfig {

    @Value("${server.internal.port:8000}")
    private Integer internalPort;

    @Autowired
    public ServerConnectorConfig() {
    }

    @Bean
    public FilterRegistrationBean<InternalApiFilter> internalApiFilter() {
        FilterRegistrationBean<InternalApiFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new InternalApiFilter(this.internalPort));
        registrationBean.addUrlPatterns("/internalapi/*");

        return registrationBean;
    }

    @Bean
    public ServletWebServerFactory servletContainer() {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        tomcat.addAdditionalTomcatConnectors(createHttpConnector());
        return tomcat;
    }

    private Connector createHttpConnector() {
        Connector connector = new Connector(TomcatServletWebServerFactory.DEFAULT_PROTOCOL);
        connector.setScheme("http");
        connector.setPort(this.internalPort);

        return connector;
    }
}
