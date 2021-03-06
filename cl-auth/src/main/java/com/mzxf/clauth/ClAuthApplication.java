package com.mzxf.clauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableDiscoveryClient
@EnableResourceServer
@ComponentScan("com.mzxf.clauth.configure")
public class ClAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClAuthApplication.class, args);
    }

}
