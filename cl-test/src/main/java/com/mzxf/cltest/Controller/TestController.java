package com.mzxf.cltest.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/test/ribbon")
    public String ribbon() {
        return "123123";
    }
}
