package com.example.liststreet.service;


import com.example.liststreet.entity.District;
import com.example.liststreet.entity.Street;
import com.example.liststreet.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DistrictService {

    @Autowired
    private DistrictRepository districtRepository;

    public List<District> findAll(){
        return districtRepository.findAll();
    }

    public Optional<District> findById(String id){
        return districtRepository.findById(String.valueOf(id));
    }


}
