package com.mzxf.cluser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/test")
public class TestController {
    private static final String REST_URL_PREFIX = "http://cl-test";
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/ribbon")
    public String ribbon() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/test/ribbon", String.class);
    }
}
