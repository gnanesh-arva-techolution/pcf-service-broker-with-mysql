package com.hashmap.service.broker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableAutoConfiguration(exclude = {JpaRepositoriesAutoConfiguration.class, HibernateJpaAutoConfiguration.class, DataSourceAutoConfiguration.class})
public class HashmapServiceBrokerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HashmapServiceBrokerApplication.class, args);
    }
}
