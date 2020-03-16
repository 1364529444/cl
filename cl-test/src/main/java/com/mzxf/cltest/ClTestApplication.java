package com.mzxf.cltest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ClTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClTestApplication.class, args);
    }

}
