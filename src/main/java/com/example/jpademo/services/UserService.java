package com.example.jpademo.services;

import com.example.jpademo.entities.User;
import com.example.jpademo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public List<User> findById(long id) {
        if (userRepository.findById(id).isPresent()) {
            List<User> users = new ArrayList<>();
            users.add(userRepository.findById(id).get());
            return users;
        }
        return new ArrayList<>();
    }
}
