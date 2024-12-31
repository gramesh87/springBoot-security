package com.ramesh.security.api.repository;

import com.ramesh.security.api.entity.LoginUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<LoginUser, Integer> {
    Optional<LoginUser> findByName(String username);
}

