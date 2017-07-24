package com.hashmap.service.broker.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Gnanesh Arva
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.hashmap.service.broker.client", "com.hashmap.broker.client.controller"})
public class HashmapServiceBrokerClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(HashmapServiceBrokerClientApplication.class, args);
    }
}
