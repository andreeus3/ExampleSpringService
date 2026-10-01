package com.example.firstapplication.service;

import com.example.firstapplication.dto.CreateUserDTO;
import com.example.firstapplication.dto.UserDTO;
import com.example.firstapplication.entitys.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserDTO> findAll();
    Optional<UserDTO> findByID(Long ID);
    UserDTO saveUser(CreateUserDTO createUserDTO);
    void deleteByID(Long ID);
}
