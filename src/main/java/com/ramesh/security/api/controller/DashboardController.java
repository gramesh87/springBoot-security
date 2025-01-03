package com.ramesh.security.api.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Date;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    @GetMapping("/welcome")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String getWelcomeMessage(HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        return "Hello "+principal.getName()+"\n Welcome to SpringBoot Security "+ new Date();
    }
}
