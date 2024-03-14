package com.ramesh.security.api.service;

import com.ramesh.security.api.entity.LoginUser;
import com.ramesh.security.api.entity.LoginUserDetails;
import com.ramesh.security.api.exceptions.UserNotFoundException;
import com.ramesh.security.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class LoginUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<LoginUser> loginUser = userRepository.findByName(username);
        return loginUser.map(LoginUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("No user found with "+ username));
    }
}
