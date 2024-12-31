package com.ramesh.security.api.controller;

import com.ramesh.security.api.entity.LoginUser;
import com.ramesh.security.api.exceptions.UserNotFoundException;
import com.ramesh.security.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public String getHome() {
        return "This is a SpringBoot Security Demo Application";
    }

    @PostMapping("/user/add")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<String> addNewUser(@RequestBody LoginUser loginUser) {
        return userService.addNewUser(loginUser);
    }

    @GetMapping("/user/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public LoginUser getUserById(@PathVariable int id) throws UserNotFoundException {
        return userService.getLoginUserById(id);
    }

    @GetMapping("/user/all")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<LoginUser> getAllUsers() {
        return userService.getAllUsers();
    }
}
