package com.ramesh.security.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Locale;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    @GetMapping("/welcome")
    public String getWelcomeMessage() {
        return "Welcome to App";
    }

    @GetMapping("/time/welcome")
    public String getWelcomeMessageWithTime() {
        return "Welcome to App \n"+ new Date();
    }
}
