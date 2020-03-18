package com.mzxf.cltest.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Value("${cloud.test}")
    private String cName;

    @GetMapping("/test/cloud")
    public String cloud() {
        return cName;
    }

    @GetMapping("/test/ribbon")
    public String ribbon() {
        return "123123";
    }
}
