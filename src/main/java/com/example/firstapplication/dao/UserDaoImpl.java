package com.example.firstapplication.dao;

import com.example.firstapplication.entitys.User;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoImpl implements UserDao{

    private final EntityManager entityManager;

    public UserDaoImpl (EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<User> findAll(){
        return entityManager
                .createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    public Optional<User> findByID(Long ID){
        User user = entityManager.find(User.class, ID);
        return Optional.ofNullable(user);
    }

    @Override
    @Transactional
    public User saveUser(User user){
        return entityManager.merge(user);
    }

    @Override
    @Transactional
    public void deleteByID(Long ID){
        User user = entityManager.find(User.class, ID);
        if(user!=null){
            entityManager.remove(user);
        }

    }
}
