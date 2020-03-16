package com.mzxf.clconfserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ClConfServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClConfServerApplication.class, args);
    }

}
