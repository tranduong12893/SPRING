package com.example.liststreet.service;

import com.example.liststreet.entity.Street;
import com.example.liststreet.repository.StreetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StreetService {

    @Autowired
    private StreetRepository streetRepository;

    public List<Street> findAll(){
        return streetRepository.findAll();
    }

    public Optional<Street> findById( String id){
        return streetRepository.findById(String.valueOf(id));
    }

    public Street save( Street street){
        return streetRepository.save(street);
    }

    public void deleteById( String id){
        streetRepository.deleteById(String.valueOf(id));
    }
}
