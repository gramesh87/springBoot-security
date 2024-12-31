package com.ramesh.security.api.controller;

import com.ramesh.security.api.entity.LoginUser;
import com.ramesh.security.api.exceptions.UserNotFoundException;
import com.ramesh.security.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> addNewUser(@RequestBody LoginUser loginUser) {
        return userService.addNewUser(loginUser);
    }

    @GetMapping("/user/{id}")
    public LoginUser getUserById(@PathVariable int id) throws UserNotFoundException {
        return userService.getLoginUserById(id);
    }

    @GetMapping("/user/all")
    public List<LoginUser> getAllUsers() {
        return userService.getAllUsers();
    }
}
