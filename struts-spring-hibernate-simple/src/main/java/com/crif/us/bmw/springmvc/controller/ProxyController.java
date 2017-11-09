package com.crif.us.bmw.springmvc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProxyController {

    @PostMapping("/startApp")
    public String startApp() {
        return "startApp!";
    }

    @PostMapping("/getApp")
    public String getApp() {
        return "getApp!";
    }

    @PostMapping("/updateApp")
    public String updateApp() {
        return "updateApp!";
    }

    @GetMapping("/test")
    public String test() {
        return "Test......";
    }
}