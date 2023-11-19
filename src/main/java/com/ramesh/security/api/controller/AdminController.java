package com.ramesh.security.api.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String getAdminPage(HttpServletRequest request) {
        return "Hello "+request.getUserPrincipal().getName()+", Welcome to Admin Panel. \n"+ new Date();
    }
}
