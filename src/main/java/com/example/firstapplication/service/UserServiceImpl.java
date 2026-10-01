package com.example.firstapplication.service;

import com.example.firstapplication.dao.UserDao;
import com.example.firstapplication.dto.CreateUserDTO;
import com.example.firstapplication.dto.UserDTO;
import com.example.firstapplication.entitys.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao){
        this.userDao=userDao;
    }

    @Override
    public List<UserDTO> findAll(){

       List<User> users = userDao.findAll();
       List<UserDTO> userDTOS = new ArrayList<>();

       for(User user: users){
           UserDTO dto = new UserDTO();
           dto.setName(user.getName());
           dto.setAge(user.getAge());
           dto.setDOB(user.getDOB());

           userDTOS.add(dto);
       }

       return userDTOS;
    }

    @Override
    public Optional<UserDTO> findByID(Long ID){
        Optional<User> userOptional = userDao.findByID(ID);

        if(userOptional.isEmpty()){
            return Optional.empty();
        }

        UserDTO userDTO = new UserDTO();
        User user = userOptional.get();

        userDTO.setName(user.getName());
        userDTO.setDOB(user.getDOB());
        userDTO.setAge(user.getAge());

        return Optional.of(userDTO);

    }

    @Override
    public UserDTO saveUser(CreateUserDTO createUserDTO){
        User user = new User();

        user.setAge(createUserDTO.getAge());
        user.setDOB(createUserDTO.getDOB());
        user.setPassword(createUserDTO.getPassword());
        user.setName(createUserDTO.getName());

        User savedUser = userDao.saveUser(user);

        UserDTO response = new UserDTO();

        response.setAge(savedUser.getAge());
        response.setDOB(savedUser.getDOB());
        response.setName(savedUser.getName());

        return response;
    }

    @Override
    public void deleteByID(Long ID){

    }

}
