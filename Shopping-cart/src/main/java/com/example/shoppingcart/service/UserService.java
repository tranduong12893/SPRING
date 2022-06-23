package com.example.shoppingcart.service;

import com.example.shoppingcart.entity.User;
import com.example.shoppingcart.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public Optional<User> findById( Long id){
        return userRepository.findById(String.valueOf(id));
    }

    public User save( User user){
        return userRepository.save(user);
    }

    public void deleteById( Long id){
        userRepository.deleteById(String.valueOf(id));
    }
}
