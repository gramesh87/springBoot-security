package com.ramesh.security.api.service;

import com.ramesh.security.api.entity.LoginUser;
import com.ramesh.security.api.exceptions.UserNotFoundException;
import com.ramesh.security.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public ResponseEntity<String> addNewUser(LoginUser loginUser) {
        loginUser.setPassword(passwordEncoder.encode(loginUser.getPassword()));
        repository.save(loginUser);
        return ResponseEntity.ok("User "+ loginUser.getName() +" saved successfully. \nUserId :"+ loginUser.getId());
    }

    public LoginUser getLoginUserById(int id) throws UserNotFoundException {
        Optional<LoginUser> loginUser = repository.findById(id);
        return loginUser.orElseThrow(() -> new UserNotFoundException("No user found with id "+ id));
    }

    public List<LoginUser> getAllUsers() {
        return repository.findAll(Sort.by("name"));
    }
}
