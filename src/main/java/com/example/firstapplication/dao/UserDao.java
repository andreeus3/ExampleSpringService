package com.example.firstapplication.dao;

import com.example.firstapplication.entitys.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    List<User> findAll();
    Optional<User> findByID(Long ID);
    User saveUser(User user);
    void deleteByID(Long ID);
    
}
