package com.io.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.io.entity.User;

import jakarta.persistence.Id;

public interface UserRepository extends JpaRepository<User, Id> {
    Optional<User> findByUsername(String username);


}
