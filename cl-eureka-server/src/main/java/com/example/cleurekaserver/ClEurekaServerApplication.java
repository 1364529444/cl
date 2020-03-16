package com.example.cleurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ClEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClEurekaServerApplication.class, args);
    }

}
